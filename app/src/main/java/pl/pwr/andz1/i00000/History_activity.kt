package pl.pwr.andz1.i00000

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pl.pwr.andz1.i00000.databinding.ActivityHistoryBinding
import pl.pwr.andz1.i00000.databinding.ActivityMainBinding


class History_activity: AppCompatActivity() {

    private lateinit var binding: ActivityHistoryBinding
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var data = intent.getSerializableExtra("history_data")

        viewManager = LinearLayoutManager(this)
        viewAdapter = MyAdapter(data as ArrayList<BMI_instance>)
        binding.myRecyclerView.addItemDecoration(
            DividerItemDecoration(
                binding.myRecyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        binding.myRecyclerView.apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }
    }
}