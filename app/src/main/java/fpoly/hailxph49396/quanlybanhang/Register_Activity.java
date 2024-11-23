package fpoly.hailxph49396.quanlybanhang;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class Register_Activity extends AppCompatActivity {
    Button btn_trove, btn_dangkitaikhon;
    TextInputLayout txt_user, txt_pass, txt_Repass;
    TextInputEditText ed_user, ed_pass, ed_Repass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txt_user = findViewById(R.id.txt_user);
        ed_user = findViewById(R.id.ed_user);
        txt_pass = findViewById(R.id.txt_pass);
        ed_pass = findViewById(R.id.ed_pass);
        txt_Repass = findViewById(R.id.txt_Repass);
        ed_Repass = findViewById(R.id.ed_Repass);
        btn_trove = findViewById(R.id.btn_trove);
        btn_dangkitaikhon = findViewById(R.id.btn_dangkytaikhoan);

        btn_trove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register_Activity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        btn_dangkitaikhon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String User = ed_user.getText().toString();
                String Pass = ed_pass.getText().toString();
                String Repass = ed_Repass.getText().toString();

                //Valudate
                if (User.equals("") || Pass.equals("") || Repass.equals("")){
                    Toast.makeText(Register_Activity.this, "Nhập đầy dủ dũ liệu", Toast.LENGTH_SHORT).show();

                } else if (!Pass.equals(Repass)) {
                    Toast.makeText(Register_Activity.this, "Nhập mật khẩu phải trùng khớp", Toast.LENGTH_SHORT).show();

                }else {
                    Intent i = new Intent(Register_Activity.this, LoginActivity.class);
                    i.putExtra("User", User);
                    i.putExtra("Pass", Pass);
                    i.putExtra("Repass", Repass);
                    setResult(1,i);
                    finish();
                }
            }
        });
    }
}