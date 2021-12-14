package com.godzuche.truckport.ui.onboarding

import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.godzuche.truckport.databinding.OnboardingScreenItemLayoutBinding
import com.godzuche.truckport.models.OnBoardingData
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView

class OnBoardingViewPager2Adapter(
    private val onBoardingDataList: List<OnBoardingData>
) :
    RecyclerView.Adapter<OnBoardingViewPager2Adapter.OnBoardingViewPager2ViewHolder>() {

    private lateinit var onNextButtonClicked: ((Int) -> Unit)
    private lateinit var onLoginButtonClicked: ((Int) -> Unit)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): OnBoardingViewPager2ViewHolder {
        val itemView =
            OnboardingScreenItemLayoutBinding.inflate(LayoutInflater.from(parent.context),
                parent,
                false)
        return OnBoardingViewPager2ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: OnBoardingViewPager2ViewHolder, position: Int) {
        val onBoardingData = onBoardingDataList[position]
        holder.bind(onBoardingData, position)
    }

    override fun getItemCount() = onBoardingDataList.size

    inner class OnBoardingViewPager2ViewHolder(
        binding: OnboardingScreenItemLayoutBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        private val backgroundImage: ImageView = binding.imvImageBackground
        private val titleText: MaterialTextView = binding.tvTitle
        private val descriptionText: MaterialTextView = binding.tvDescription
        private val nextButton: MaterialButton = binding.btNext
        private val loginButton: MaterialButton = binding.btLogin

        fun bind(onBoardingData: OnBoardingData, position: Int) {
            backgroundImage.setImageResource(onBoardingData.imgUrl)
            titleText.text = onBoardingData.title
            descriptionText.text = onBoardingData.desc

            nextButton.setOnClickListener {
                onNextButtonClicked(position)
            }

            loginButton.setOnClickListener {
                onLoginButtonClicked(position)
            }

            when (position) {
                1 -> {
                    titleText.apply {
                        alterMargin()
                    }
                    nextButton.text = "Get Started"
                    loginButton.visibility = View.VISIBLE
                }
                2 -> {
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
                TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                    344F,
                    context.resources.displayMetrics)
                    .toInt(), 0, 0)
            this.layoutParams = layoutParams
        }
    }


        fun setOnItemSelectedNextListener (onItemSelectedNextListener: (Int) -> Unit) {
            this.onNextButtonClicked = onItemSelectedNextListener
        }

        fun setOnItemSelectedLoginListener (onItemSelectedLoginListener: (Int) -> Unit) {
            this.onLoginButtonClicked = onItemSelectedLoginListener
        }

}