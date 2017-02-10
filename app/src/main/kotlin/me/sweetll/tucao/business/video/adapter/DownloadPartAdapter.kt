package me.sweetll.tucao.business.video.adapter

import android.widget.CheckedTextView
import android.widget.ImageView
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.BaseViewHolder
import me.sweetll.tucao.R
import me.sweetll.tucao.business.download.model.Part
import zlc.season.rxdownload2.entity.DownloadFlag

class DownloadPartAdapter(data: MutableList<Part>?) : BaseQuickAdapter<Part, BaseViewHolder>(R.layout.item_part, data) {
    override fun convert(helper: BaseViewHolder, part: Part) {
        val titleText = helper.getView<CheckedTextView>(R.id.checked_text_title)
        val downloadedImg = helper.getView<ImageView>(R.id.img_downloaded)
        val downloadingImg = helper.getView<ImageView>(R.id.img_downloading)

        titleText.text = part.title
        titleText.isChecked = part.checked
        if (part.durls.isNotEmpty()) {
            // 存在
            titleText.isEnabled = false
            if (part.flag == DownloadFlag.COMPLETED) {
                downloadedImg.visibility = View.VISIBLE
                downloadingImg.visibility = View.GONE
            } else {
                downloadedImg.visibility = View.GONE
                downloadingImg.visibility = View.VISIBLE
            }
        } else {
            // 不存在
            titleText.isEnabled = true
            downloadedImg.visibility = View.GONE
            downloadingImg.visibility = View.GONE
        }
    }
}
