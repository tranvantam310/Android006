package com.windys.myapplication.ListContact;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.windys.myapplication.R;

import java.util.ArrayList;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ContactViewHolder> {

    Context context;
    ArrayList<Contact> data;
    OnItemClickListener listener;

    public ContactAdapter(Context context, ArrayList<Contact> data, OnItemClickListener listener) {
        this.context = context;
        this.data = data;
        this.listener = listener;
    }

    /*public ContactAdapter(Context context, ArrayList<Contact> data) {
        this.context = context;
        this.data = data;
    }*/

    @NonNull
    @Override
    public ContactViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(context).inflate(R.layout.contact_item, viewGroup, false);
        return new ContactViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactViewHolder contactViewHolder, int i) {

       /* contactViewHolder.tv_name.setText(data.get(i).getName());
        contactViewHolder.tv_phone.setText(data.get(i).getPhone());

        contactViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("ABC", "onClick: ");
            }
        });*/

        contactViewHolder.bind(data.get(i), listener);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    class ContactViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name, tv_phone;
        LinearLayout llContact;

        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.tv_name_contact);
            tv_phone = itemView.findViewById(R.id.tv_phone_contact);
            llContact = itemView.findViewById(R.id.ll_contact);
        }

        public void bind(final Contact contact, final OnItemClickListener listener) {

            tv_name.setText(contact.getName().toUpperCase());
            tv_phone.setText(contact.getPhone().toUpperCase());

            llContact.setOnClickListener(new View.OnClickListener() { // replace tv_phone
                @Override
                public void onClick(View v) {
                    listener.onItemClick(contact);
                    Toast.makeText(context, "jjj", Toast.LENGTH_SHORT).show();

                   /* new AlertDialog.Builder(tv_name.getContext())
                            .setTitle(contact.getName())
                            .setMessage(contact.getPhone())
                            .show();*/

                   /* Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel: " +contact.getPhone()));
                    context.startActivity(intent);*/
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Contact contact);
    }
}
