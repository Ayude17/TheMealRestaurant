package id.web.themealrestaurant;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import com.android.volley.Cache;
import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import id.web.themealrestaurant.Adapters.ListCategoryAdapter;
import id.web.themealrestaurant.object.Category;
import id.web.themealrestaurant.object.CategoryData;

public class Dashboard extends AppCompatActivity {
    private RecyclerView rvCategory;
    private ArrayList<Category>list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        rvCategory = findViewById(R.id.dataCategory);
        rvCategory.setHasFixedSize(true);

        list.addAll(CategoryData.getCategorytData());
        showRecyclerList();
    }
    private void showRecyclerList(){
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListCategoryAdapter listCategoryAdapter = new ListCategoryAdapter(list);
        rvCategory.setAdapter(listCategoryAdapter);
    }
}
