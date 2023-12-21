package com.example.ceriakids.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ceriakids.R
import com.example.ceriakids.adapter.FoodAdapter
import com.example.ceriakids.databinding.FragmentHomeBinding
import com.example.ceriakids.ui.detail.Food

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var foodAdapter: FoodAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Ambil data dari string array
        val foodNames = resources.getStringArray(R.array.data_name)
        val foodDescriptions = resources.getStringArray(R.array.data_description)
        val foodImages = resources.obtainTypedArray(R.array.data_food)

        // Buat daftar Food dari string array
        val foodList = ArrayList<Food>()
        for (i in foodNames.indices) {
            val food = Food(foodNames[i], foodDescriptions[i], foodImages.getResourceId(i, -1))
            foodList.add(food)
        }

        // Bebaskan sumber daya setelah digunakan
        foodImages.recycle()

        // Inisialisasi adapter dan set ke RecyclerView
        foodAdapter = FoodAdapter(foodList)
        binding.rvFood.adapter = foodAdapter
        binding.rvFood.layoutManager = LinearLayoutManager(requireContext())

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
