package pe.edu.upc.catchup.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONObjectRequestListener
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.json.JSONObject

import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
import pe.edu.upc.catchup.network.NewsApi
import pe.edu.upc.catchup.viewcontrollers.adapter.ArticlesAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {
    var articles = ArrayList<Article>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val articlesRecyclerView = view.articlesRecycleView
        val articlesAdapter = ArticlesAdapter(articles, view.context)
        val articlesLayoutManager = GridLayoutManager(view.context, 2)
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager
        AndroidNetworking.get(NewsApi.topHeadLinesUrl)
                .addPathParameter("apiKey", getString(R.string.news_api_key))
                .addPathParameter("country", "us")
                .setTag("CatchUp")
                .setPriority(Priority.LOW)
                .build()
                .getAsJSONObject( object: JSONObjectRequestListener{
                    override fun onResponse(response: JSONObject?) {
                        Log.d("Response", response.toString())
                        val status = response!!.getString("status")
                        if (status.equals("error", true)){
                            Log.d("CatchUp","Error when requesting")
                            return
                        }
                        val jsonArticles = response.getJSONArray("articles")
                        Log.d("CatchUp", jsonArticles.length() as String)
                        // TODO: Convert JSONArray to ArrayList<Article and assgin to articles
                    }

                    override fun onError(anError: ANError?) {
                        Log.d("CatchUp", anError!!.message)
                    }

                })
        return  view
    }


}
