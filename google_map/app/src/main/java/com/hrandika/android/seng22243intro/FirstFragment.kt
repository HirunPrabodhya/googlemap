package com.hrandika.android.seng22243intro

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.hrandika.android.seng22243intro.adapters.PhotoAdapter
import com.hrandika.android.seng22243intro.api.UserAPIService
import com.hrandika.android.seng22243intro.databinding.FragmentFirstBinding
import com.hrandika.android.seng22243intro.model.Photo
import com.hrandika.android.seng22243intro.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private val userAPIService = UserAPIService.create()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerview.layoutManager = LinearLayoutManager(view.context)
        val photos = userAPIService.getPhotos()

        val user = userAPIService.getPhotos()
        Log.i("FirstFragment", "buttonFirst")
        user.enqueue(object : Callback<List<Photo>> {
            override fun onResponse(call: Call<List<Photo>>, response: Response<List<Photo>>) {
                val photosBody = response.body()
                val adapter = PhotoAdapter(photosBody!!)
                binding.recyclerview.adapter = adapter
            }

            override fun onFailure(call: Call<List<Photo>>, t: Throwable) {

            }

        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}