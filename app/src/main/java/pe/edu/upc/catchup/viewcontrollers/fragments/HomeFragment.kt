package pe.edu.upc.catchup.viewcontrollers.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.view.*

import pe.edu.upc.catchup.R
import pe.edu.upc.catchup.models.Article
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val articles = ArrayList<Article>()
        val articlesRecyclerView = view.articlesRecycleView
        val articlesAdapter = ArticlesAdapter(articles, view.context)
        val articlesLayoutManager = GridLayoutManager(view.context, 2)
        articlesRecyclerView.adapter = articlesAdapter
        articlesRecyclerView.layoutManager = articlesLayoutManager
        return  view
    }


}
