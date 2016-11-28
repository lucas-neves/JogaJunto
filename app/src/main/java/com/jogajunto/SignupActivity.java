package com.jogajunto;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jogajunto.modelo.Cliente;
import com.jogajunto.tasks.CadastroClienteTask;
import com.jogajunto.tasks.NovoUsuarioTask;

import butterknife.ButterKnife;
import butterknife.Bind;

public class SignupActivity extends AppCompatActivity {
    private static final String TAG = "SignupActivity";
    public static boolean cadastrou = false;

    @Bind(R.id.input_name) EditText _nameText;
    @Bind(R.id.input_email) EditText _emailText;
    @Bind(R.id.input_password) EditText _passwordText;
    @Bind(R.id.btn_signup) Button _signupButton;
    @Bind(R.id.link_login) TextView _loginLink;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        ButterKnife.bind(this);

        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                finish();
            }
        });
    }

    public void signup() {
        Log.d(TAG, "Signup");

        if (!validate()) {
            onSignupFailed();
            return;
        }

        _signupButton.setEnabled(false);

        final ProgressDialog progressDialog = new ProgressDialog(SignupActivity.this,
                R.style.AppTheme_Dark_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("Criando conta...");
        progressDialog.show();

        final String name = _nameText.getText().toString();
        final String email = _emailText.getText().toString();
        final String password = _passwordText.getText().toString();

        // TODO: Implement your own signup logic here.

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {

                        // On complete call either onLoginSuccess or onLoginFailed
                        NovoUsuarioTask task = new NovoUsuarioTask();
                        boolean usuarioExiste = task.doInBackground(email);

                        if (!usuarioExiste) {

                            CadastroClienteTask taskCad = new CadastroClienteTask(getBaseContext());
                            boolean cadastrou = taskCad.doInBackground(new Cliente(name, password, email));

                            if(cadastrou){
                                onSignupSuccess();
                            }else{
                                onSignupFailed();
                            }

                        }else{
                            Toast.makeText(getBaseContext(), "E-mail já cadastrado!", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();
                    }
                }, 3000);
}


    public void onSignupSuccess() {
        _signupButton.setEnabled(true);
        setResult(RESULT_OK, null);
        cadastrou = true;
        Intent login = new Intent(this, LoginActivity.class);
        startActivity(login);
    }

    public void onSignupFailed() {
        Toast.makeText(getBaseContext(), "Criação de conta falhou", Toast.LENGTH_LONG).show();
        _signupButton.setEnabled(true);
    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 2) {
            _nameText.setError("O nome precisa conter mais de duas letras!");
            valid = false;
        } else {
            _nameText.setError(null);
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("Entre com um endereço de email válido!");
            valid = false;
        } else {
            _emailText.setError(null);
        }

        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
            _passwordText.setError("Senha entre 4 e 10 caracteres!");
            valid = false;
        } else {
            _passwordText.setError(null);
        }

        return valid;
    }
}