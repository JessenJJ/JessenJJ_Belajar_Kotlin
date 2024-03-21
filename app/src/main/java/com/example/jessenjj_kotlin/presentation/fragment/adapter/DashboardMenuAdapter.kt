package com.example.jessenjj_kotlin.presentation.fragment.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.jessenjj_kotlin.R
import com.example.jessenjj_kotlin.model.MenuDashboardModel


class DashboardMenuAdapter
    (private val context: Context, private val menuData: List<MenuDashboardModel>) : BaseAdapter() {
    private var image: ImageView? = null
    private var textMenu: TextView? = null
    private var layoutInflater: LayoutInflater? = null

    override fun getCount(): Int {
        return menuData.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var bindingView = convertView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)
                    as LayoutInflater
        }
        if (bindingView == null) {
            bindingView = layoutInflater?.inflate(R.layout.item_menu_dashboard, null)
        }

        image = bindingView?.findViewById(R.id.ivMenu)
        textMenu = bindingView?.findViewById(R.id.tvMenu)


        //ini fungsinya untuk mendapatkan data dari list berdasarkan position
        val resultMenu = menuData[position]

        //melakukan sett pada masing2 component di layout
        image?.setImageResource(resultMenu.image)
        textMenu?.text = resultMenu.menuName

        return bindingView
    }

}