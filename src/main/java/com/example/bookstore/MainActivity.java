package com.example.bookstore;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    TextView authorName, price, totalPrice;
    Spinner sp;
    Button buyBook, reservBook, buyReservedBook;
    double finalPrice=0;

    ArrayList<Book>bookList = new ArrayList<>();
    ArrayList<String>names = new ArrayList<>();
    HashMap<String,Double> reservedBooks = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        authorName = findViewById(R.id.tvName);
        price = findViewById(R.id.tvPrice);
        totalPrice = findViewById(R.id.tvTotal);
        sp = findViewById(R.id.spinner);
        buyBook = findViewById(R.id.btnBuy);
        reservBook = findViewById(R.id.btnReserv);
        buyReservedBook = findViewById(R.id.btnBuyReserved);
        fillData();


        //spinner
        ArrayAdapter<String> aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, names);
        sp.setAdapter(aa);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                price.setText(String.valueOf(bookList.get(i).getBookPrice()));
                authorName.setText(String.valueOf(bookList.get(i).getBookAuthorName()));
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        buyBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double currentPrice = Double.parseDouble(price.getText().toString());


                finalPrice += currentPrice;
                totalPrice.setText(String.format("%.2f",finalPrice));
            }
        });

        reservBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double currentPrice = Double.parseDouble(price.getText().toString());


                finalPrice += currentPrice*0.1;
                totalPrice.setText(String.format("%.2f",finalPrice));

                String bookName = String.valueOf(sp);
                reservedBooks.put(bookName,currentPrice);



            }
        });

        buyReservedBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double currentPrice;
                currentPrice = Double.parseDouble(price.getText().toString());
                for(Double value : reservedBooks.values())
                {
                    if (value < 50.0)
                    {
                        currentPrice = value*0.9;
                    }
                    else
                    {
                        currentPrice = 0.0;
                    }
                    finalPrice += currentPrice;
                }



                totalPrice.setText(String.format("%.2f",finalPrice));
            }
        });
    }

    public void fillData()
    {
        bookList.add(new Book("Don Quixote","Miguel de Cervantes",20.86));
        bookList.add(new Book("A Tale of Two Cities","Charles Dickens",12.10));
        bookList.add(new Book("The Lord of the Rings","J.R.R. Tolkien",52.25));
        bookList.add(new Book("The Little Prince","Antoine de Saint-Exupery",17.95));
        bookList.add(new Book("Harry Potter and the Sorcerer's Stone","J.K. Rowling",60.25));
        bookList.add(new Book("And Then There Were None","Agatha Christie",27.60));
        bookList.add(new Book("The Dream of the Red Chamber","Cao Xueqin",12.81));

        for (Book bk : bookList)
        {
            names.add(bk.getBookName());
        }
    }
}