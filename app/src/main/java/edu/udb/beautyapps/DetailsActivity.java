package edu.udb.beautyapps;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {
    private ImageView imgItemDetail;
    private TextView tvTituloDetail;
    private TextView tvDescripcionDetail;
    private TextView tvPriceId;
    private TextView txtDate;
    private Button btnDate;
    private Button btnSave;

    private Service service;
    private DatabaseReference databaseReference;
    private String userId;
    private String dateSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        service = (Service) getIntent().getExtras().get("serviceDetail");
        setTitle(service.getName());

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        userId = user.getUid();

        initViews();
        initValues();
    }
     private void initViews(){

         imgItemDetail =  findViewById(R.id.imageview);
         tvTituloDetail = findViewById(R.id.name);
         tvDescripcionDetail = findViewById(R.id.description);
         tvPriceId = findViewById(R.id.priceId);
         txtDate = findViewById(R.id.txtDate);
         btnDate = findViewById(R.id.btnDate);
         btnSave = findViewById(R.id.btnSave);

        }
     private void initValues(){

        imgItemDetail.setImageResource(service.getImage());
         tvTituloDetail.setText(service.getName());
         tvDescripcionDetail.setText(service.getDescription());
         tvPriceId.setText(String.valueOf(service.getPrice()));
         btnDate.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 showDatePicker();
             }
         });
         btnSave.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 saveAppointment();
             }
         });

    }

    private void showDatePicker(){


        Date date = new Date();

        final Calendar c = Calendar.getInstance();
        c.setTime(date);
        int mYear = c.get(Calendar.YEAR); // current year
        int mMonth = c.get(Calendar.MONTH); // current month
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this, (view, year, monthOfYear, dayOfMonth) -> {

            c.set(Calendar.YEAR,year);
            c.set(Calendar.MONTH,monthOfYear);
            c.set(Calendar.DAY_OF_MONTH,dayOfMonth);

            date.setTime(c.getTimeInMillis());

            SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
            dateSelected = fmtOut.format(date);
            String appointmentStr = "Dia de la cita: " + dateSelected;

            txtDate.setText(appointmentStr);
            btnDate.setText("Cambiar fecha");

        }, mYear, mMonth, mDay);

        datePickerDialog.setOnCancelListener(DialogInterface::dismiss);

        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());
        datePickerDialog.show();
        datePickerDialog.setCanceledOnTouchOutside(false);

    }

    private void saveAppointment(){

        SimpleDateFormat fmtOut = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        String dateCreated = fmtOut.format(new Date());
        Appointment appointment = new Appointment(dateCreated,dateSelected,service);

        databaseReference.child("Users").child(userId).setValue(appointment);

        Toast.makeText(this, "Cita Guardada", Toast.LENGTH_SHORT).show();
        finish();
    }
}