package com.carroza.logistics.carroza_app.ui.onboarding

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.carroza.logistics.carroza_app.R
import com.carroza.logistics.carroza_app.models.OnBoardingData


class OnBoardingFragment : Fragment() {

    private lateinit var onBoardingViewPagerAdapter: OnBoardingViewPager2Adapter
    private lateinit var onBoardingViewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_onboarding, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        onBoardingViewPagerAdapter = OnBoardingViewPager2Adapter(getOnBoardingItems())
        onBoardingViewPager = view.findViewById(R.id.pager)
        onBoardingViewPager.adapter = onBoardingViewPagerAdapter

        // Listening for the Next Button clicks
        onBoardingViewPagerAdapter.setOnItemSelectedNextListener { itemPosition ->
            if (itemPosition < (getOnBoardingItems().size - 1)) {
                gotoNextScreen(itemPosition)
            } else {
                gotoSignUpFragment()
            }
        }

        // Listening for the other Button clicks
        onBoardingViewPagerAdapter.setOnItemSelectedLoginListener { itemPosition ->
            if (itemPosition < (getOnBoardingItems().size - 1)) {
                gotoLoginFragment()
            } else {
                gotoSignUpFragment()
            }
        }

        /*onBoardingViewPager.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
            }
        })*/
        (onBoardingViewPager.getChildAt(0) as RecyclerView).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    private fun gotoLoginFragment() {
        findNavController().navigate(OnBoardingFragmentDirections.actionOnboardingFragmentToLoginFragment())
    }

    private fun gotoSignUpFragment() {
        findNavController().navigate(OnBoardingFragmentDirections.actionOnboardingFragmentToSignUpFragment())
    }

    private fun gotoNextScreen(itemPosition: Int) {
        onBoardingViewPager.setCurrentItem((itemPosition + 1), true)
    }

    private fun getOnBoardingItems(): List<OnBoardingData> {
        // Add some data to our onBoarding model class
        val onBoardingData: MutableList<OnBoardingData> = ArrayList()

        onBoardingData.add(OnBoardingData(
            "Let's get started",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt massa etiam dolor erat. Mi vitae.",
            R.drawable._downloader_1
        ))
        onBoardingData.add(OnBoardingData(
            "Let's get started",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt massa etiam dolor erat. Mi vitae.",
            R.drawable._downloader_2
        ))
        onBoardingData.add(OnBoardingData(
            "Let's get started",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Tincidunt massa etiam dolor erat. Mi vitae.",
            R.drawable._downloader_2
        ))

        return onBoardingData
    }

}