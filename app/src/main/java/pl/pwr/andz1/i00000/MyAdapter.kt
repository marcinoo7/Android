package pl.pwr.andz1.i00000

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.history_blocks.view.*
import pl.pwr.andz1.i00000.databinding.HistoryBlocksBinding

class MyAdapter(private val myDataset: ArrayList<BMI_instance>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(view: HistoryBlocksBinding) : RecyclerView.ViewHolder(view.root)
    {
        val bind = HistoryBlocksBinding.bind(view.root)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): MyAdapter.MyViewHolder {
        val binding =
            HistoryBlocksBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = myDataset[position]
        holder.bind.apply {
            bmiDataTextView.text = data.bmi_value
            heightDataTextView.text = data.height
            massDataTextView.text = data.mass
            systemTextView.text = data.system
        }
    }

    override fun getItemCount() = myDataset.size
}