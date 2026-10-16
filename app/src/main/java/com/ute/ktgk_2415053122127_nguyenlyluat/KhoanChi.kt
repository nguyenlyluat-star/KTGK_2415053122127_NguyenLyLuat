package com.ute.ktgk_2415053122127_nguyenlyluat

import java.io.Serializable

data class KhoanChi(
    var maKhoanChi_127: String = "",
    var tenKhoanChi_127: String = "",
    var soTien_127: Double = 0.0,
    var ghiChu_127: String = "",
    var daThanhToan_127: Boolean = false,
    var loaiChi_127: String = "Khác"
) : Serializable {

    fun layThongTin_127(): String {
        val trangThai_127 = if (daThanhToan_127) "Đã thanh toán" else "Chưa thanh toán"
        return "[$loaiChi_127] $tenKhoanChi_127 - ${soTien_127.toLong()} VNĐ ($trangThai_127)"
    }

    fun laSoTienHopLe_127(): Boolean {
        return soTien_127 > 0
    }
}