package com.ute.ktgk_2415053122127_nguyenlyluat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChinhSuaChiTieuActivity : AppCompatActivity() {

    private lateinit var edtSuaTen_127: EditText
    private lateinit var edtSuaSoTien_127: EditText
    private lateinit var edtSuaLoaiChi_127: EditText
    private lateinit var edtSuaGhiChu_127: EditText
    private lateinit var btnLuu_127: Button
    private lateinit var btnHuy_127: Button

    private var currentKhoanChi_127: KhoanChi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chinh_sua_chi_tieu)

        supportActionBar?.title = "Nguyễn Lý Luật - 2415053122127 - Quản lý chi tiêu cá nhân"

        edtSuaTen_127 = findViewById(R.id.edtSuaTen_127)
        edtSuaSoTien_127 = findViewById(R.id.edtSuaSoTien_127)
        edtSuaLoaiChi_127 = findViewById(R.id.edtSuaLoaiChi_127)
        edtSuaGhiChu_127 = findViewById(R.id.edtSuaGhiChu_127)
        btnLuu_127 = findViewById(R.id.btnLuu_127)
        btnHuy_127 = findViewById(R.id.btnHuy_127)

        currentKhoanChi_127 = intent.getSerializableExtra("CURRENT_KHOAN_CHI") as? KhoanChi

        currentKhoanChi_127?.let {
            edtSuaTen_127.setText(it.tenKhoanChi_127)
            edtSuaSoTien_127.setText(it.soTien_127.toString())
            edtSuaLoaiChi_127.setText(it.loaiChi_127)
            edtSuaGhiChu_127.setText(it.ghiChu_127)
        }

        btnLuu_127.setOnClickListener {
            val tenMoi_127 = edtSuaTen_127.text.toString().trim()
            val soTienMoiStr_127 = edtSuaSoTien_127.text.toString().trim()
            val loaiChiMoi_127 = edtSuaLoaiChi_127.text.toString().trim()
            val ghiChuMoi_127 = edtSuaGhiChu_127.text.toString().trim()

            if (tenMoi_127.isEmpty()) {
                Toast.makeText(this, "Tên không được để trống!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val soTienMoi_127 = soTienMoiStr_127.toDoubleOrNull()
            if (soTienMoi_127 == null || soTienMoi_127 <= 0) {
                Toast.makeText(this, "Số tiền không hợp lệ!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            currentKhoanChi_127?.apply {
                tenKhoanChi_127 = tenMoi_127
                soTien_127 = soTienMoi_127
                loaiChi_127 = loaiChiMoi_127
                ghiChu_127 = ghiChuMoi_127
            }

            val resultIntent_127 = Intent()
            resultIntent_127.putExtra("UPDATED_KHOAN_CHI", currentKhoanChi_127)
            setResult(RESULT_OK, resultIntent_127)
            finish()
        }

        btnHuy_127.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}