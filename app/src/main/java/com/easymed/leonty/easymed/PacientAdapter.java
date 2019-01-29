package com.easymed.leonty.easymed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class PacientAdapter extends RecyclerView.Adapter<PacientAdapter.ViewHolder> {

    private List<Pacient> pacients;

    PacientAdapter(List<Pacient> pacients) {
        this.pacients = pacients;
    }

    @NonNull
    @Override
    public PacientAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pacient_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PacientAdapter.ViewHolder viewHolder, int i) {
        viewHolder.surname.setText(pacients.get(i).getSurname());
        viewHolder.name_pacient.setText(pacients.get(i).getName());
        viewHolder.patronymic.setText(pacients.get(i).getPatronymic());
        viewHolder.birth.setText(pacients.get(i).getBirthDate());
        viewHolder.diagnosis.setText(pacients.get(i).getDiagnosis());
        viewHolder.id = pacients.get(i).getId();
    }

    @Override
    public int getItemCount() {
        return pacients.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView surname;
        TextView name_pacient;
        TextView patronymic;
        TextView birth;
        TextView diagnosis;
        int id;

        ViewHolder(@NonNull final View itemView) {
            super(itemView);
            surname = itemView.findViewById(R.id.surname);
            name_pacient = itemView.findViewById(R.id.name);
            patronymic = itemView.findViewById(R.id.patronym);
            birth = itemView.findViewById(R.id.birthdate);
            diagnosis = itemView.findViewById(R.id.diagnosis);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Context context = v.getContext();
                    Intent intent = new Intent(context, EditPacient.class);
                    Bundle b = new Bundle();
                    b.putInt("id", id);
                    intent.putExtras(b);
                    context.startActivity(intent);
                }
            });
        }
    }
}