package com.example.loggedregistrationdatainsert;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.loggedregistrationdatainsert.databinding.ActivityLoginBinding;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;
    ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Retrofit retrofit = ApiClient.getClient();
        apiInterface = retrofit.create(ApiInterface.class);


        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ModelActivity modelActivity=new ModelActivity();
                modelActivity.setPhone(binding.userphone.getText().toString());
                modelActivity.setPassword(binding.editTextNumberPassword.getText().toString());


                apiInterface.login(modelActivity).enqueue(new Callback<ModelActivity>() {
                    @Override
                    public void onResponse(Call<ModelActivity> call, Response<ModelActivity> response) {


                        if (response.body().getResponse().equals("ok")) {

                            String getName=response.body().getName();
                            String getPhone=response.body().getPhone();

                            Intent intent=new Intent(LoginActivity.this,ProfileActivity.class);
                            intent.putExtra("name",getName);
                            intent.putExtra("phone",getPhone);
                            startActivity(intent);
                        }else {

                            Toast.makeText(LoginActivity.this, "Invalid phone or Password", Toast.LENGTH_SHORT).show();
                        }

                    }


                    @Override
                    public void onFailure(Call<ModelActivity> call, Throwable t) {

                        Toast.makeText(LoginActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();


                    }
                });
            }
        });

    }
}