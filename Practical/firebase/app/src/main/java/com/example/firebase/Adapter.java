package com.example.firebase;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.service.autofill.UserData;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.orhanobut.dialogplus.DialogPlus;
import com.orhanobut.dialogplus.DialogPlusBuilder;
import com.orhanobut.dialogplus.ViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private List<Info> infoarray;

    public Adapter(List<Info> infoarray){
        this.infoarray = infoarray;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.data_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder,final int position) {
        final Info info = this.infoarray.get(position);
        holder.name.setText(info.getName());
        holder.phonenumber.setText(info.getNumber());
        holder.email.setText(info.getEmail());

        holder.update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final DialogPlus dialogPlus = DialogPlus.newDialog(holder.update.getContext()).setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.activity_view)).create();
                View view =dialogPlus.getHolderView();
                EditText name =  view.findViewById(R.id.Name);
                EditText number = view.findViewById(R.id.PhoneNumber);
                EditText email = view.findViewById(R.id.Email);
                Button save = view.findViewById(R.id.add);

                name.setText(info.getName());
                number.setText(info.getNumber());
                email.setText(info.getEmail());

                dialogPlus.show();

                save.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Map<String,Object> map = new HashMap<>();
                        map.put("Name",name.getText().toString());
                        map.put("Number",number.getText().toString());
                        map.put("Email",email.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("User").child('').updateChildren(map)
                                .addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void aVoid) {
                                        dialogPlus.dismiss();
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        dialogPlus.dismiss();
                                    }
                                });
                    }
                });
            }
        });

    }

    @Override
    public int getItemCount() {
        return infoarray.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView name,phonenumber,email;
        private Button update,remove;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.text_name);
            phonenumber = itemView.findViewById(R.id.text_phonenumber);
            email = itemView.findViewById(R.id.text_email);
            //update = itemView.findViewById(R.id.update);
            //remove = itemView.findViewById(R.id.remove);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Info info = infoarray.get(getAdapterPosition());
                    Intent i = new Intent(context, ViewActivity.class);
                    i.putExtra("User", (Parcelable) info);
                    context.startActivity(i);
                }
            });*/

        }
    }
}
