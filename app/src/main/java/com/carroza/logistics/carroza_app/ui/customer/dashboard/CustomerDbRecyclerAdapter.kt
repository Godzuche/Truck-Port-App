package com.carroza.logistics.carroza_app.ui.customer.dashboard

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.carroza.logistics.carroza_app.R
import com.carroza.logistics.carroza_app.databinding.CustomerDbRvItemLayoutBinding
import com.google.android.material.card.MaterialCardView
import com.google.android.material.textview.MaterialTextView

class CustomerDbRecyclerAdapter(private val context: Context) :
    RecyclerView.Adapter<CustomerDbRecyclerAdapter.ViewHolder>() {

    private val itemList = listOf<CustomerDbRvItemModel>(
        CustomerDbRvItemModel(
            R.drawable.ic_qr_bike,
            "QR Bike",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
        CustomerDbRvItemModel(
            R.drawable.ic_qr_truck,
            "QR Truck",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
        ),
        CustomerDbRvItemModel(
            R.drawable.ic_qr_bus,
            "QR Bus",
            "Easy booking of buses for your trips and conferences."
        ),
        CustomerDbRvItemModel(
            R.drawable.ic_qr_tracker,
            "QR Tracker",
            "View live location of your parcel or goods."
        )
    )

    private val inflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomerDbRvItemLayoutBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item, position)
        holder.cardView.setOnClickListener { holder.onClickCardView(item, position) }
    }

    override fun getItemCount() = itemList.size

    inner class ViewHolder(val binding: CustomerDbRvItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val cardView: MaterialCardView = binding.cardView
        val imgIcon: ImageView = binding.imvIcon
        val tvTitle: MaterialTextView = binding.tvTitle
        val tvDesc: MaterialTextView = binding.tvDesc

        fun bind(item: CustomerDbRvItemModel, position: Int) {
            imgIcon.setImageResource(item.icon)
            tvTitle.text = item.title
            tvDesc.text = item.description

            when (position) {
                0 -> {
                    tvTitle.setTextColor(ContextCompat.getColor(context, R.color.purple))
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.pale_purple
                        )
                    )
                }
                1 -> {
                    tvTitle.setTextColor(ContextCompat.getColor(context, R.color.blue))
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.pale_blue
                        )
                    )
                }
                2 -> {
                    tvTitle.setTextColor(ContextCompat.getColor(context, R.color.red))
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.pale_pink
                        )
                    )
                }
                3 -> {
                    tvTitle.setTextColor(ContextCompat.getColor(context, R.color.yellow))
                    cardView.setCardBackgroundColor(
                        ContextCompat.getColor(
                            context,
                            R.color.pale_yellow
                        )
                    )
                }
            }
        }

        fun onClickCardView(item: CustomerDbRvItemModel, position: Int) {
            when (position) {
                0 -> {
                    val action = CustomerDashboardFragmentDirections.actionCustomerDashboardFragmentToBookDeliveryFragment()
                    val view = binding.root
                    view.findNavController().navigate(action)
                }
                1 -> {

                }
                2 -> {

                }
                3 -> {
                }
                else -> {

                }
            }
        }

    }


}