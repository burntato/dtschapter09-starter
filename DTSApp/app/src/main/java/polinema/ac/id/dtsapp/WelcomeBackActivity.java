package polinema.ac.id.dtsapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class WelcomeBackActivity extends AppCompatActivity {

    private SharedPreferences sharedPrefs;

    // Key-key untuk data yang disimpan di SharedPrefernces
    private static final String USERNAME_KEY = "key_username";
    private static final String KEEP_LOGIN_KEY = "key_keep_login";

    private static final String DUMMY_USERNAME = "ian";
    private static final String DUMMY_PASSWORD = "verycool";

    // Komponen
    private EditText edtUsername;
    private EditText edtPassword;
    private CheckBox chkRememberUsername;
    private CheckBox chkKeepLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_back);

        this.initComponents();

        // Inisialisasi SharedPreferences
        this.sharedPrefs = this.getSharedPreferences("dtsapp_sharedprefs", Context.MODE_PRIVATE);

        this.autoLogin();

        this.loadSavedUsername();
    }

    private void initComponents()
    {
        // Init components
        this.edtUsername = this.findViewById(R.id.edt_username);
        this.edtPassword = this.findViewById(R.id.edt_password);
        this.chkRememberUsername = this.findViewById(R.id.chk_remember_username);
        this.chkKeepLogin = this.findViewById(R.id.chk_keep_login);
    }

    // Click Actions

    public void onTxvForgotPassword_Click(View view)
    {
        Intent i = new Intent(WelcomeBackActivity.this, ForgotPasswordActivity.class);
        startActivity(i);
    }

    public void onBtnLogin_Click(View view)
    {
        boolean valid = this.validateCredential();

        if (valid)
        {
            this.saveUsername();
            this.makeAutoLogin();

            Intent i = new Intent(WelcomeBackActivity.this, MainActivity.class);
            startActivity(i);
        }
        else {
            Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show();
        }
    }

    public void onBtnRegister_Click(View view)
    {
        Intent i = new Intent(WelcomeBackActivity.this, RegisterActivity.class);
        startActivity(i);
    }

    // End of Click Actions

    private void saveUsername()
    {
        // Menyimpan username bila diperlukan
    }

    private void loadSavedUsername()
    {
        // Memeriksa apakah sebelumnya ada username yang tersimpan?
        // Jika ya, maka tampilkan username tersebut di EditText username.

        String savedUsername = this.sharedPrefs.getString(USERNAME_KEY, null);

        if (savedUsername != null)
        {
            this.edtUsername.setText(savedUsername);

            this.chkRememberUsername.setChecked(true);
        }
    }

    private boolean validateCredential()
    {
        String currentUsername = this.edtUsername.getText().toString();
        String currentPassword = this.edtPassword.getText().toString();

        return (Objects.equals(currentUsername, DUMMY_USERNAME)
                && Objects.equals(currentPassword, DUMMY_PASSWORD));
    }


    private void makeAutoLogin()
    {
        // Mengatur agar selanjutnya pada saat aplikasi dibuka menjadi otomatis login

        SharedPreferences.Editor editor = this.sharedPrefs.edit();

        editor.putBoolean(KEEP_LOGIN_KEY, this.chkKeepLogin.isChecked());

        editor.apply();
    }

    // QUIZ!
    private void autoLogin()
    {
        // Cek apakah sebelumnya aplikasi diatur agar bypass login?
        // Jika ya maka langsung buka activity berikutnya

        boolean keepLogin = this.sharedPrefs.getBoolean(KEEP_LOGIN_KEY, false);

        if (keepLogin)
        {
            Intent i = new Intent(WelcomeBackActivity.this, MainActivity.class);
            startActivity(i);
        }
    }
}
