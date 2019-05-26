package kr.susemi99.testkpermissions

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.fondesa.kpermissions.extension.onAccepted
import com.fondesa.kpermissions.extension.permissionsBuilder

class ScanFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.scan_fragment, container, false)
  }

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)

    requestPermission()
  }

  private fun requestPermission() {
    permissionsBuilder(Manifest.permission.CAMERA)
      .build()
      .onAccepted { startScan() }
      .send()
  }

  private fun startScan() {
    Toast.makeText(activity, "scan started", Toast.LENGTH_SHORT).show()
  }
}
