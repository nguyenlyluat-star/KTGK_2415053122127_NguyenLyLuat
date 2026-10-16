package com.ute.ktgk_2415053122127_nguyenlyluat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class ChiTietChiTieuActivity : AppCompatActivity() {

    private lateinit var txtTen_127: TextView
    private lateinit var txtSoTien_127: TextView
    private lateinit var txtLoaiChi_127: TextView
    private lateinit var txtGhiChu_127: TextView
    private lateinit var txtTrangThai_127: TextView
    private lateinit var btnChinhSua_127: Button
    private lateinit var btnQuayLai_127: Button

    private var objKhoanChi_127: KhoanChi? = null

    private val chinhSuaLauncher_127 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val updatedObj_127 = result.data?.getSerializableExtra("UPDATED_KHOAN_CHI") as? KhoanChi
            if (updatedObj_127 != null) {
                objKhoanChi_127 = updatedObj_127
                hienThiThongTin_127()
                Toast.makeText(this, "Đã cập nhật thông tin mới!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chi_tiet_chi_tieu)

        supportActionBar?.title = "Nguyễn Lý Luật - 2415053122127 - Quản lý chi tiêu cá nhân"

        txtTen_127 = findViewById(R.id.txtTen_127)
        txtSoTien_127 = findViewById(R.id.txtSoTien_127)
        txtLoaiChi_127 = findViewById(R.id.txtLoaiChi_127)
        txtGhiChu_127 = findViewById(R.id.txtGhiChu_127)
        txtTrangThai_127 = findViewById(R.id.txtTrangThai_127)
        btnChinhSua_127 = findViewById(R.id.btnChinhSua_127)
        btnQuayLai_127 = findViewById(R.id.btnQuayLai_127)

        objKhoanChi_127 = intent.getSerializableExtra("KHOAN_CHI_DATA") as? KhoanChi

        if (objKhoanChi_127 == null || !objKhoanChi_127!!.laSoTienHopLe_127()) {
            Toast.makeText(this, "Dữ liệu khoản chi không hợp lệ!", Toast.LENGTH_LONG).show()
            finish()
            return
        }

        hienThiThongTin_127()

        btnChinhSua_127.setOnClickListener {
            val intentEdit_127 = Intent(this, ChinhSuaChiTieuActivity::class.java)
            intentEdit_127.putExtra("CURRENT_KHOAN_CHI", objKhoanChi_127)
            chinhSuaLauncher_127.launch(intentEdit_127)
        }

        btnQuayLai_127.setOnClickListener {
            finish()
        }
    }

    private fun hienThiThongTin_127() {
        objKhoanChi_127?.let {
            txtTen_127.text = "Tên khoản chi: ${it.tenKhoanChi_127}"
            txtSoTien_127.text = "Số tiền: ${it.soTien_127.toLong()} VNĐ"
            txtLoaiChi_127.text = "Loại chi: ${it.loaiChi_127}"
            txtGhiChu_127.text = "Ghi chú: ${it.ghiChu_127}"
            txtTrangThai_127.text = "Trạng thái: " + if (it.daThanhToan_127) "Đã thanh toán" else "Chưa thanh toán"
        }
    }
}