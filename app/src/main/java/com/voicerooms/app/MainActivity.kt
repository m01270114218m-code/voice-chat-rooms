package com.voicerooms.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : Activity() {
 override fun onCreate(state: Bundle?) { super.onCreate(state); setContentView(home()) }
 private fun home(): LinearLayout { val root=LinearLayout(this); root.orientation=LinearLayout.VERTICAL; root.setPadding(28,48,28,28); root.setBackgroundColor(Color.rgb(8,10,18));
  val title=TextView(this); title.text="VOICE ROOMS"; title.textSize=28f; title.setTextColor(Color.WHITE); root.addView(title)
  val sub=TextView(this); sub.text="8-seat social voice rooms • 3D/SVGA ready"; sub.textSize=15f; sub.setTextColor(Color.LTGRAY); root.addView(sub)
  repeat(3){ i -> val room=TextView(this); room.text="\n  ${listOf("Royal Lounge","Galaxy Night","Diamond Club")[i]}\n  8 microphones • Live"; room.textSize=18f; room.setTextColor(Color.WHITE); root.addView(room, LinearLayout.LayoutParams(-1,150)) }
  return root }
}
