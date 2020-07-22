package com.rafyee.rafyee_rajiv.pstuprofile.Dean;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.rafyee.rafyee_rajiv.pstuprofile.MainActivity;
import com.rafyee.rafyee_rajiv.pstuprofile.R;

public class Dean extends AppCompatActivity {

    private ImageView backButton;
    private LinearLayout agricultureDean, cseDean, bbaDean, ansvmDean, fishariesDean, disasterDean, nfsDean, landDean, pgsDean;

    private String agriculture_dean_name, agriculture_dean_designation, agriculture_dean_contact, agriculture_dean_email, agriculture_dean_fax, agriculture_dean_address;
    private String cse_dean_name, cse_dean_designation, cse_dean_contact, cse_dean_email, cse_dean_fax, cse_dean_address;
    private String nfs_dean_name, nfs_dean_designation, nfs_dean_contact,nfs_dean_email, nfs_dean_fax, nfs_dean_address;
    private String bba_dean_name, bba_dean_designation, bba_dean_contact, bba_dean_email, bba_dean_fax, bba_dean_address;
    private String fisharies_dean_name, fisharies_dean_designation, fisharies_dean_contact, fisharies_dean_email, fisharies_dean_fax, fisharies_dean_address;
    private String ansvm_dean_name, ansvm_dean_designation, ansvm_dean_contact, ansvm_dean_email, ansvm_dean_fax, ansvm_dean_address;
    private String land_dean_name, land_dean_designation, land_dean_contact, land_dean_email, land_dean_fax, land_dean_address;
    private String disaster_dean_name, disaster_dean_designation, disaster_dean_contact, disaster_dean_email, disaster_dean_fax, disaster_dean_address;
    private String pgs_dean_name, pgs_dean_designation, pgs_dean_contact, pgs_dean_email, pgs_dean_fax, pgs_dean_address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dean);
        getSupportActionBar().hide();

        backButton = findViewById(R.id.activityDean_backButton);
        agricultureDean = findViewById(R.id.agricultureDean);
        cseDean = findViewById(R.id.cseDean);
        bbaDean = findViewById(R.id.bbaDean);
        ansvmDean = findViewById(R.id.ansvmDean);
        fishariesDean = findViewById(R.id.fishariesDean);
        disasterDean = findViewById(R.id.disasterDean);
        nfsDean = findViewById(R.id.nfsDean);
        landDean = findViewById(R.id.landDean);
        pgsDean = findViewById(R.id.pgsDean);

        getAllStrings();

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backIntent = new Intent(Dean.this, MainActivity.class);
                startActivity(backIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_right,R.anim.slideout_from_left);
            }
        });

        agricultureDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agricultureDeanIntent = new Intent(Dean.this, DeanDetails.class);
                agricultureDeanIntent.putExtra("dean_name", agriculture_dean_name);
                agricultureDeanIntent.putExtra("dean_designation", agriculture_dean_designation);
                agricultureDeanIntent.putExtra("dean_contact", agriculture_dean_contact);
                agricultureDeanIntent.putExtra("dean_contact_english", "01716950727");
                agricultureDeanIntent.putExtra("dean_email", agriculture_dean_email);
                agricultureDeanIntent.putExtra("dean_fax", agriculture_dean_fax);
                agricultureDeanIntent.putExtra("dean_address", agriculture_dean_address);
                agricultureDeanIntent.putExtra("dean_image", R.drawable.agri_fish_dean);
                startActivity(agricultureDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        cseDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cseDeanIntent = new Intent(Dean.this, DeanDetails.class);
                cseDeanIntent.putExtra("dean_name", cse_dean_name);
                cseDeanIntent.putExtra("dean_designation", cse_dean_designation);
                cseDeanIntent.putExtra("dean_contact", cse_dean_contact);
                cseDeanIntent.putExtra("dean_contact_english", "01865102400");
                cseDeanIntent.putExtra("dean_email", cse_dean_email);
                cseDeanIntent.putExtra("dean_fax", cse_dean_fax);
                cseDeanIntent.putExtra("dean_address", cse_dean_address);
                cseDeanIntent.putExtra("dean_image", R.drawable.cse_dean);
                startActivity(cseDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        bbaDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bbaDeanIntent = new Intent(Dean.this, DeanDetails.class);
                bbaDeanIntent.putExtra("dean_name", bba_dean_name);
                bbaDeanIntent.putExtra("dean_designation", bba_dean_designation);
                bbaDeanIntent.putExtra("dean_contact", bba_dean_contact);
                bbaDeanIntent.putExtra("dean_contact_english", "01714209306");
                bbaDeanIntent.putExtra("dean_email", bba_dean_email);
                bbaDeanIntent.putExtra("dean_fax", bba_dean_fax);
                bbaDeanIntent.putExtra("dean_address", bba_dean_address);
                bbaDeanIntent.putExtra("dean_image", R.drawable.bba_dean);
                startActivity(bbaDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        ansvmDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ansvmDeanIntent = new Intent(Dean.this, DeanDetails.class);
                ansvmDeanIntent.putExtra("dean_name", ansvm_dean_name);
                ansvmDeanIntent.putExtra("dean_designation", ansvm_dean_designation);
                ansvmDeanIntent.putExtra("dean_contact", ansvm_dean_contact);
                ansvmDeanIntent.putExtra("dean_contact_english", "01711466430");
                ansvmDeanIntent.putExtra("dean_email", ansvm_dean_email);
                ansvmDeanIntent.putExtra("dean_fax", ansvm_dean_fax);
                ansvmDeanIntent.putExtra("dean_address", ansvm_dean_address);
                ansvmDeanIntent.putExtra("dean_image", R.drawable.ansvm_dean);
                startActivity(ansvmDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        fishariesDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fishariesDeanIntent = new Intent(Dean.this, DeanDetails.class);
                fishariesDeanIntent.putExtra("dean_name", fisharies_dean_name);
                fishariesDeanIntent.putExtra("dean_designation", fisharies_dean_designation);
                fishariesDeanIntent.putExtra("dean_contact", fisharies_dean_contact);
                fishariesDeanIntent.putExtra("dean_contact_english", "01716379131");
                fishariesDeanIntent.putExtra("dean_email", fisharies_dean_email);
                fishariesDeanIntent.putExtra("dean_fax", fisharies_dean_fax);
                fishariesDeanIntent.putExtra("dean_address", fisharies_dean_address);
                fishariesDeanIntent.putExtra("dean_image", R.drawable.agri_fish_dean);
                startActivity(fishariesDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        disasterDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent disasterDeanIntent = new Intent(Dean.this, DeanDetails.class);
                disasterDeanIntent.putExtra("dean_name", disaster_dean_name);
                disasterDeanIntent.putExtra("dean_designation", disaster_dean_designation);
                disasterDeanIntent.putExtra("dean_contact", disaster_dean_contact);
                disasterDeanIntent.putExtra("dean_contact_english", "04456010");
                disasterDeanIntent.putExtra("dean_email", disaster_dean_email);
                disasterDeanIntent.putExtra("dean_fax", disaster_dean_fax);
                disasterDeanIntent.putExtra("dean_address", disaster_dean_address);
                disasterDeanIntent.putExtra("dean_image", R.drawable.vc_sir);
                startActivity(disasterDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        nfsDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nfsDeanIntent = new Intent(Dean.this, DeanDetails.class);
                nfsDeanIntent.putExtra("dean_name", nfs_dean_name);
                nfsDeanIntent.putExtra("dean_designation", nfs_dean_designation);
                nfsDeanIntent.putExtra("dean_contact", nfs_dean_contact);
                nfsDeanIntent.putExtra("dean_contact_english", "0442756012");
                nfsDeanIntent.putExtra("dean_email", nfs_dean_email);
                nfsDeanIntent.putExtra("dean_fax", nfs_dean_fax);
                nfsDeanIntent.putExtra("dean_address", nfs_dean_address);
                nfsDeanIntent.putExtra("dean_image", R.drawable.vc_sir);
                startActivity(nfsDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        landDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent landDeanIntent = new Intent(Dean.this, DeanDetails.class);
                landDeanIntent.putExtra("dean_name", land_dean_name);
                landDeanIntent.putExtra("dean_designation", land_dean_designation);
                landDeanIntent.putExtra("dean_contact", land_dean_contact);
                landDeanIntent.putExtra("dean_contact_english", "01716919563");
                landDeanIntent.putExtra("dean_email", land_dean_email);
                landDeanIntent.putExtra("dean_fax", land_dean_fax);
                landDeanIntent.putExtra("dean_address", land_dean_address);
                landDeanIntent.putExtra("dean_image", R.drawable.land_pgs_dean);
                startActivity(landDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });

        pgsDean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pgsDeanIntent = new Intent(Dean.this, DeanDetails.class);
                pgsDeanIntent.putExtra("dean_name", pgs_dean_name);
                pgsDeanIntent.putExtra("dean_designation", pgs_dean_designation);
                pgsDeanIntent.putExtra("dean_contact", pgs_dean_contact);
                pgsDeanIntent.putExtra("dean_contact_english", "01716919563");
                pgsDeanIntent.putExtra("dean_email", pgs_dean_email);
                pgsDeanIntent.putExtra("dean_fax", pgs_dean_fax);
                pgsDeanIntent.putExtra("dean_address", pgs_dean_address);
                pgsDeanIntent.putExtra("dean_image", R.drawable.land_pgs_dean);
                startActivity(pgsDeanIntent);
                finish();
                overridePendingTransition(R.anim.slide_from_left, R.anim.slideout_from_right);
            }
        });
    }

    public void onBackPressed() {
        Intent intent = new Intent(Dean.this, MainActivity.class);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slideout_from_left);
        super.onBackPressed();
    }

    private void getAllStrings() {

        agriculture_dean_name = getResources().getString(R.string.agriculture_dean_name);
        agriculture_dean_designation = getResources().getString(R.string.agriculture_dean_designation);
        agriculture_dean_contact = getResources().getString(R.string.agriculture_dean_contact);
        agriculture_dean_email = getResources().getString(R.string.agriculture_dean_email);
        agriculture_dean_fax = getResources().getString(R.string.agriculture_dean_fax);
        agriculture_dean_address = getResources().getString(R.string.agriculture_dean_address);

        cse_dean_name = getResources().getString(R.string.cse_dean_name);
        cse_dean_designation = getResources().getString(R.string.cse_dean_designation);
        cse_dean_contact = getResources().getString(R.string.cse_dean_contact);
        cse_dean_email = getResources().getString(R.string.cse_dean_email);
        cse_dean_fax = getResources().getString(R.string.cse_dean_fax);
        cse_dean_address = getResources().getString(R.string.cse_dean_address);

        nfs_dean_name = getResources().getString(R.string.nfs_dean_name);
        nfs_dean_designation = getResources().getString(R.string.nfs_dean_designation);
        nfs_dean_contact = getResources().getString(R.string.nfs_dean_contact);
        nfs_dean_email = getResources().getString(R.string.nfs_dean_email);
        nfs_dean_fax = getResources().getString(R.string.nfs_dean_fax);
        nfs_dean_address = getResources().getString(R.string.nfs_dean_address);

        bba_dean_name = getResources().getString(R.string.bba_dean_name);
        bba_dean_designation = getResources().getString(R.string.bba_dean_designation);
        bba_dean_contact = getResources().getString(R.string.bba_dean_contact);
        bba_dean_email = getResources().getString(R.string.bba_dean_email);
        bba_dean_fax = getResources().getString(R.string.bba_dean_fax);
        bba_dean_address = getResources().getString(R.string.bba_dean_address);

        fisharies_dean_name = getResources().getString(R.string.cse_dean_name);
        fisharies_dean_designation = getResources().getString(R.string.fisharies_dean_designation);
        fisharies_dean_contact = getResources().getString(R.string.cse_dean_name);
        fisharies_dean_email = getResources().getString(R.string.fisharies_dean_email);
        fisharies_dean_fax = getResources().getString(R.string.fisharies_dean_fax);
        fisharies_dean_address = getResources().getString(R.string.fisharies_dean_address);

        ansvm_dean_name = getResources().getString(R.string.ansvm_dean_name);
        ansvm_dean_designation = getResources().getString(R.string.ansvm_dean_designation);
        ansvm_dean_contact = getResources().getString(R.string.ansvm_dean_contact);
        ansvm_dean_email = getResources().getString(R.string.ansvm_dean_email);
        ansvm_dean_fax = getResources().getString(R.string.ansvm_dean_fax);
        ansvm_dean_address = getResources().getString(R.string.ansvm_dean_address);

        land_dean_name = getResources().getString(R.string.land_dean_name);
        land_dean_designation = getResources().getString(R.string.land_dean_designation);
        land_dean_contact = getResources().getString(R.string.land_dean_contact);
        land_dean_email = getResources().getString(R.string.land_dean_email);
        land_dean_fax = getResources().getString(R.string.land_dean_fax);
        land_dean_address = getResources().getString(R.string.land_dean_address);

        disaster_dean_name = getResources().getString(R.string.disaster_dean_name);
        disaster_dean_designation = getResources().getString(R.string.disaster_dean_designation);
        disaster_dean_contact = getResources().getString(R.string.disaster_dean_contact);
        disaster_dean_email = getResources().getString(R.string.disaster_dean_email);
        disaster_dean_fax = getResources().getString(R.string.disaster_dean_fax);
        disaster_dean_address = getResources().getString(R.string.disaster_dean_address);

        pgs_dean_name = getResources().getString(R.string.pgs_dean_name);
        pgs_dean_designation = getResources().getString(R.string.pgs_dean_designation);
        pgs_dean_contact = getResources().getString(R.string.pgs_dean_contact);
        pgs_dean_email = getResources().getString(R.string.pgs_dean_email);
        pgs_dean_fax = getResources().getString(R.string.pgs_dean_fax);
        pgs_dean_address = getResources().getString(R.string.pgs_dean_address);

    }
}