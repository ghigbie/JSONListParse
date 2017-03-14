package com.geogehigbie.jsonlistproject;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContactDetail extends Fragment {

    private View view;
    private String name;
    private String phone;
    private String email;
    private String birthday;
    private String company;
    private String city;
    private String state;
    private String street;
    private String zip;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_contact_detail, container, false);
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            name = bundle.getString("name");
            phone = bundle.getString("phone");
            email = bundle.getString("email");
            birthday = bundle.getString("birthday");
            company = bundle.getString("company");
            city = bundle.getString("city") + ", ";
            state = bundle.getString("state") + " ";
            street = bundle.getString("street");
            zip = bundle.getString("zip");
        }
        setAllTextViews();

        return view;
    }

    public void setAllTextViews() {

        TextView nameText = (TextView) view.findViewById(R.id.name_text);
        TextView phoneText = (TextView) view.findViewById(R.id.phone_text);
        TextView emailText = (TextView) view.findViewById(R.id.email_text);
        TextView birthdayText = (TextView) view.findViewById(R.id.birthday_text);
        TextView companyText = (TextView) view.findViewById(R.id.company_text);
        TextView cityText = (TextView) view.findViewById(R.id.city_text);
        TextView stateText = (TextView) view.findViewById(R.id.state_text);
        TextView streetText = (TextView) view.findViewById(R.id.street_text);
        TextView zipText = (TextView) view.findViewById(R.id.zip_text);

        nameText.setText(name);
        phoneText.setText(phone);
        emailText.setText(email);
        birthdayText.setText(birthday);
        companyText.setText(company);
        cityText.setText(city);
        stateText.setText(state);
        streetText.setText(street);
        zipText.setText(zip);
    }






}
