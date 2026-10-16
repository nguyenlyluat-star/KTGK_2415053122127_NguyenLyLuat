package com.ute.ktgk_2415053122127_nguyenlyluat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtTen_127: EditText
    private lateinit var edtSoTien_127: EditText
    private lateinit var edtGhiChu_127: EditText
    private lateinit var edtLoaiChi_127: EditText
    private lateinit var btnThem_127: Button
    private lateinit var btnXemChiTiet_127: Button

    private var khoanChiHienTai_127: KhoanChi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = "Nguyễn Lý Luật - 2415053122127 - Quản lý chi tiêu cá nhân"

        edtTen_127 = findViewById(R.id.edtTenKhoanChi_127)
        edtSoTien_127 = findViewById(R.id.edtSoTien_127)
        edtGhiChu_127 = findViewById(R.id.edtGhiChu_127)
        edtLoaiChi_127 = findViewById(R.id.edtLoaiChi_127)
        btnThem_127 = findViewById(R.id.btnThemKhoanChi_127)
        btnXemChiTiet_127 = findViewById(R.id.btnXemChiTiet_127)

        btnThem_127.setOnClickListener {
            themKhoanChi_127()
        }

        btnXemChiTiet_127.setOnClickListener {
            moManHinhChiTiet_127()
        }
    }

    private fun themKhoanChi_127() {
        val ten_127 = edtTen_127.text.toString().trim()
        val soTienStr_127 = edtSoTien_127.text.toString().trim()
        val ghiChu_127 = edtGhiChu_127.text.toString().trim()
        val loaiChi_127 = edtLoaiChi_127.text.toString().trim().ifEmpty { "Khác" }

        if (ten_127.isEmpty()) {
            Toast.makeText(this, "Tên khoản chi không được để trống!", Toast.LENGTH_SHORT).show()
            return
        }

        val soTien_127 = soTienStr_127.toDoubleOrNull()
        if (soTien_127 == null || soTien_127 <= 0) {
            Toast.makeText(this, "Số tiền phải lớn hơn 0!", Toast.LENGTH_SHORT).show()
            return
        }

        khoanChiHienTai_127 = KhoanChi(
            maKhoanChi_127 = "KC127_${System.currentTimeMillis()}",
            tenKhoanChi_127 = ten_127,
            soTien_127 = soTien_127,
            ghiChu_127 = ghiChu_127,
            daThanhToan_127 = false,
            loaiChi_127 = loaiChi_127
        )

        Toast.makeText(this, "Đã thêm khoản chi thành công!", Toast.LENGTH_SHORT).show()
    }

    private fun moManHinhChiTiet_127() {
        if (khoanChiHienTai_127 == null) {
            Toast.makeText(this, "Vui lòng thêm khoản chi trước!", Toast.LENGTH_SHORT).show()
            return
        }

        val intent_127 = Intent(this, ChiTietChiTieuActivity::class.java)
        intent_127.putExtra("KHOAN_CHI_DATA", khoanChiHienTai_127)
        startActivity(intent_127)
    }
}