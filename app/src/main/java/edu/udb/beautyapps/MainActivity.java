package edu.udb.beautyapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerview;
    private List<String> titles;
    private List<Service> serviceList;
    private List<Integer> mImages;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = findViewById(R.id.reclyclerview);

        serviceList = new ArrayList<>();

        serviceList.add(new Service("Acrilismo","Servicio de unias acrilicas",10.50,R.drawable.acrilismo));
        serviceList.add(new Service("Alisado","Servicio de alisado de cabella",15.50,R.drawable.alisado));
        serviceList.add(new Service("Cejas","Servicio de cejas",5.50,R.drawable.cejas));
        serviceList.add(new Service("Corte","Servicio de  corte",6.50,R.drawable.corte));
        serviceList.add(new Service("Lavado","Servicio de lavado",9.00,R.drawable.lavado));
        serviceList.add(new Service("manicure","Servicio de manicure",12.00,R.drawable.manicure));
        serviceList.add(new Service("masaje","Servicio de masaje",4.50,R.drawable.masaje));
        serviceList.add(new Service("pedicure","Servicio de pedicure",10.50,R.drawable.pedicure));
        serviceList.add(new Service("tinte","Servicio de tinte",11.50,R.drawable.tinte));
        serviceList.add(new Service("Maquillaje","Servicio de maquillaje",20.00,R.drawable.maquillaje));

        adapter = new MyAdapter(this,serviceList);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2, GridLayoutManager.VERTICAL, false);
        mRecyclerview.setLayoutManager(gridLayoutManager);
        mRecyclerview.setHasFixedSize(true);

        mRecyclerview.setAdapter(adapter);

        mRecyclerview.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Service service = serviceList.get(position);
                Intent intent  = new Intent(getApplicationContext(),DetailsActivity.class);
                intent.putExtra("serviceDetail",service);
                startActivity(intent);
            }
        }));
    }
}