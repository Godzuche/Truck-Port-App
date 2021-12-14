package com.godzuche.truckport.adapters

import android.content.Context
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginTop
import androidx.core.view.setMargins
import androidx.recyclerview.widget.RecyclerView
import com.godzuche.truckport.R
import com.godzuche.truckport.databinding.OnboardingScreenItemLayoutBinding
import com.godzuche.truckport.models.OnBoardingData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class OnBoardingViewPager2Adapter(private val context: Context, private val onBoardingDataList: List<OnBoardingData>) :
    RecyclerView.Adapter<OnBoardingViewPager2Adapter.OnBoardingViewPager2ViewHolder>() {

    inner class OnBoardingViewPager2ViewHolder(binding: OnboardingScreenItemLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val backgroundImage: ImageView = binding.imvImageBackground
        val titleText: MaterialTextView = binding.tvTitle
        val descriptionText: MaterialTextView = binding.tvDescription
        val nextButton: MaterialButton = binding.btNext
        val loginButton: MaterialButton = binding.btLogin

        fun setOnBoardingData(onBoardingData: OnBoardingData, position: Int) {
            backgroundImage.setImageResource(onBoardingData.imgUrl)
            titleText.text = onBoardingData.title
            descriptionText.text = onBoardingData.desc
             when (position) {
                 1 -> {
                     titleText.apply {
                         alterMargin()
                     }
                     nextButton.text = "Get Started"
                     loginButton.visibility = View.VISIBLE
                 }
                 2 ->  {
                     titleText.apply {
                         alterMargin()
                     }
                     nextButton.text = "As a customer"
                     loginButton.apply {
                         text = "As a partner"
                         visibility = View.VISIBLE
                     }
                 }
             }
        }

        // Alter the top margin of the materialTextView
        private fun MaterialTextView.alterMargin() {
            val layoutParams = this.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.setMargins(23,
                // Convert 344 dp to Int
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 344F, context.resources.displayMetrics)
                    .toInt(), 0, 0)
            this.layoutParams = layoutParams
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): OnBoardingViewPager2ViewHolder {
        val itemView = OnboardingScreenItemLayoutBinding.inflate(LayoutInflater.from(context), parent, false)
        return OnBoardingViewPager2ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnBoardingViewPager2ViewHolder, position: Int) {
        val onBoardingData = onBoardingDataList[position]
        holder.setOnBoardingData(onBoardingData, position)
    }

    override fun getItemCount() = onBoardingDataList.size
}