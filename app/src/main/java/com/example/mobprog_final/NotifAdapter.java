package com.example.mobprog_final;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class NotifAdapter extends RecyclerView.Adapter<NotifAdapter.View_holder> {

    NotifModel[] notif_data_list;

    public NotifAdapter(NotifModel[] notif_data_list) {
        this.notif_data_list = notif_data_list;
    }

    @NonNull
    @Override
    public View_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View notif_list_items = layoutInflater.inflate(R.layout.recycler_view_notif, null);

        View_holder view_holder = new View_holder(notif_list_items);

        return view_holder;
    }

    @Override
    public void onBindViewHolder(@NonNull NotifAdapter.View_holder holder, int position) {
        NotifModel notif_model = notif_data_list[position];

        holder.notif_img.setImageResource(notif_model.getImg());
        holder.notif_title.setText(notif_model.getTitle());
        holder.notif_text.setText(notif_model.getText());

        holder.notif_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent clickNotifIntent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(clickNotifIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return notif_data_list.length;
    }

    public class View_holder extends RecyclerView.ViewHolder {
        ImageView notif_img;
        TextView notif_title, notif_text;
        CardView notif_card;

        public View_holder(@NonNull View itemView) {
            super(itemView);

            notif_img = itemView.findViewById(R.id.imageNotifView);
            notif_title = itemView.findViewById(R.id.titleNotifView);
            notif_text = itemView.findViewById(R.id.textNotifView);
            notif_card = itemView.findViewById(R.id.notifCard);
        }
    }
}

