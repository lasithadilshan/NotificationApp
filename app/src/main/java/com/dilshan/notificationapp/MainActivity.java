package com.dilshan.notificationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        if (!isConnected()){
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel("C1","channel 1", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager managerr = getSystemService(NotificationManager.class);
            managerr.createNotificationChannel(channel);
        }
            Toast.makeText(MainActivity.this, "No Internet Access", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(MainActivity.this, "Welcome To Our App", Toast.LENGTH_SHORT).show();
        }




        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), "C1");
//        builder.setSmallIcon(R.drawable.logo1);
        builder.setContentTitle("Your Order got Delivered!!!");
//        builder.setContentText("Your order:" + orderid + " of Rs." + totala + " was Delivered to you on " + dateee);
        builder.setSubText("Transaction");
        builder.setAutoCancel(true);


//        Intent intent = new Intent(getApplicationContext(), purchaseHistory.class);
//                        Intent intent = new Intent(getApplicationContext(), AdminPanel.class);


//                    intent.putExtra("visit_id",chef.getUser());
//        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 100, intent, 0);
//        builder.setContentIntent(pendingIntent);

//        Notification notification = builder.build();
//        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(getApplicationContext());
//        managerCompat.notify(new Random().nextInt(), notification);




    }

    private boolean isConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getApplicationContext().getSystemService(context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo()!=null && connectivityManager.getActiveNetworkInfo().isConnectedOrConnecting();

    }
}