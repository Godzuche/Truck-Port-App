package com.godzuche.truckport

import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.godzuche.truckport.adapters.OnBoardingViewPager2Adapter
import com.godzuche.truckport.models.OnBoardingData


class OnBoardingFragment : Fragment() {

    private lateinit var onBoardingViewPagerAdapter: OnBoardingViewPager2Adapter
    private lateinit var tabLayout: Layout
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

        onBoardingViewPagerAdapter = OnBoardingViewPager2Adapter(requireContext(), getOnBoardingItems())
        onBoardingViewPager = view.findViewById(R.id.pager)
        onBoardingViewPager.adapter = onBoardingViewPagerAdapter
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