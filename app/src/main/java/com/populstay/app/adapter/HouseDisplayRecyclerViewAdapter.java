package com.populstay.app.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.populstay.app.R;
import com.populstay.app.bean.HouseInfo;

import java.util.List;

/**
 * Created by Jerry
 */

public class HouseDisplayRecyclerViewAdapter extends RecyclerView.Adapter<HouseDisplayRecyclerViewAdapter.ViewHolder> {
	private List<HouseInfo> mHouseList;

	// Provide a reference to the views for each data item
	// Complex data items may need more than one view per item, and
	// you provide access to all the views for a data item in a view holder
	public static class ViewHolder extends RecyclerView.ViewHolder {
		// each data item is just a string in this case
		private ImageView mIvHouseCover;
		private TextView mTvHouseName;
		private TextView mTvHouseAddress;
		private TextView mTvHousePrice;
		private TextView mTvHouseCount;

		private ViewHolder(View v) {
			super(v);
			mIvHouseCover = v.findViewById(R.id.iv_house_cover);
			mTvHouseName = v.findViewById(R.id.tv_house_name);
			mTvHouseAddress = v.findViewById(R.id.tv_house_address);
			mTvHousePrice = v.findViewById(R.id.tv_house_price);
			mTvHouseCount = v.findViewById(R.id.tv_house_count);
		}
	}

	// Provide a suitable constructor (depends on the kind of dataset)
	public HouseDisplayRecyclerViewAdapter(List<HouseInfo> houseList) {
		mHouseList = houseList;
	}

	// Create new views (invoked by the layout manager)
	@Override
	public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
		// create a new view
		View v = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.item_rv_house_display, parent, false);
		ViewHolder vh = new ViewHolder(v);
		return vh;
	}

	// Replace the contents of a view (invoked by the layout manager)
	@Override
	public void onBindViewHolder(ViewHolder holder, int position) {
		// - get element from your dataset at this position
		// - replace the contents of the view with that element
		HouseInfo houseInfo = mHouseList.get(position);
//        holder.mIvHouseCover.setImageBitmap(houseInfo.getIvHouseCover());
		holder.mTvHouseName.setText(houseInfo.getTvHouseName());
		holder.mTvHouseAddress.setText(houseInfo.getTvHouseAddress());
		holder.mTvHousePrice.setText(houseInfo.getTvHousePrice());
		holder.mTvHouseCount.setText(houseInfo.getTvHouseCount());

	}

	// Return the size of your dataset (invoked by the layout manager)
	@Override
	public int getItemCount() {
		return mHouseList.size();
	}
}