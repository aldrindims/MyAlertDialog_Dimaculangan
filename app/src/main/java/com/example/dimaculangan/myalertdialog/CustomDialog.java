package com.example.dimaculangan.myalertdialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Aldrin on 05/10/2017.
 */

public class CustomDialog extends DialogFragment{

    LayoutInflater inflater;
    View view;
    EditText et_User, et_Password;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        inflater = getActivity().getLayoutInflater();
        view = inflater.inflate(R.layout.login_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setView(view);
        builder.setPositiveButton("Login", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                et_User = (EditText) view.findViewById(R.id.et_username);
                et_Password = (EditText) view.findViewById(R.id.et_password);
                String user = et_User.getText().toString();
                String pass = et_Password.getText().toString();
                String msg = "Username is " + user + ", Password is " + pass;
                Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        builder.setTitle("Login");

        Dialog dialog = builder.create();
        return dialog;
    }
}
