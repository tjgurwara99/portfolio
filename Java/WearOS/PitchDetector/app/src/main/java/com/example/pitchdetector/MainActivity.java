package com.example.pitchdetector;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.support.wearable.activity.WearableActivity;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.Locale;

import be.tarsos.dsp.AudioDispatcher;
import be.tarsos.dsp.AudioEvent;
import be.tarsos.dsp.AudioProcessor;
import be.tarsos.dsp.io.android.AudioDispatcherFactory;
import be.tarsos.dsp.pitch.PitchDetectionHandler;
import be.tarsos.dsp.pitch.PitchDetectionResult;
import be.tarsos.dsp.pitch.PitchProcessor;
import be.tarsos.dsp.pitch.PitchProcessor.PitchEstimationAlgorithm;

public class MainActivity extends WearableActivity {

    private TextView mTextView;
    private float cent;

    private int REQUEST_AUDIO = 1;
    private int REQUEST_VIBRATE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // You can use the API that requires the permission.
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);

        // Enables Always-on
        setAmbientEnabled();
    }

    private void getNote(float pitch, TextView v) {
        cent = (float) (1200 * Math.log(pitch / 440.0) / Math.log(2.0));
        float c;
        if (cent < 0) {
            c = cent % 1200;
            c += 1200;
        } else {
            c = cent % 1200;
        }
        if (c > 50 && c <= 150) {
            v.setText("A#");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 90 && c < 110) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 95 && c < 105) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 150 && c <= 250) {
            v.setText("B");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 190 && c < 210) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 195 && c < 205) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 250 && c <= 350) {
            v.setText("C");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 290 && c < 310) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 295 && c < 305) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 350 && c <= 450) {
            v.setText("C#");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 390 && c < 410) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 395 && c < 405) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 450 && c <= 550) {
            v.setText("D");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 490 && c < 510) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 495 && c < 505) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 550 && c <= 650) {
            v.setText("D#");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 590 && c < 610) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 595 && c < 605) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 650 && c <= 750) {
            v.setText("E");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 690 && c < 710) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 695 && c < 705) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 750 && c <= 850) {
            v.setText("F");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 790 && c < 810) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 795 && c < 805) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 850 && c <= 950) {
            v.setText("F#");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 890 && c < 910) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 895 && c < 905) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 950 && c <= 1050) {
            v.setText("G");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 990 && c < 1010) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 995 && c < 1005) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else if (c > 1050 && c <= 1150) {
            v.setText("G#");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c > 1090 && c < 1110) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c > 1095 && c < 1105) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        } else {
            v.setText("A");
            v.setTextColor(Color.parseColor("#fff8e1"));
            if (c < 10 || c > 1190) {
                v.setTextColor(Color.parseColor("#ffd54f"));
                if (c < 5 || c > 1195) {
                    v.setTextColor(Color.parseColor("#228B22"));
                    android.os.VibrationEffect.createOneShot(300, VibrationEffect.DEFAULT_AMPLITUDE);
                }
            }
        }
    }

    private void start() {
            AudioDispatcher dispatcher = AudioDispatcherFactory.fromDefaultMicrophone(22050,1024,0);
            PitchDetectionHandler pdh = new PitchDetectionHandler() {
                @Override
                public void handlePitch(PitchDetectionResult result, AudioEvent e) {
                    final float pitchInHz = result.getPitch();
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            TextView text = (TextView) findViewById(R.id.text);
                            TextView note = (TextView) findViewById(R.id.textView2);

                            if(pitchInHz != -1.0) {
                                text.setText(String.format(Locale.UK,"%.2f", pitchInHz));
                                getNote(pitchInHz, note);
                            } else {
                                text.setText(getString(R.string.idle));
                                note.setText(R.string.ready);
                                note.setTextColor(Color.parseColor("#fff8e1"));
                            }
                        }
                    });
                }
            };

            AudioProcessor p = new PitchProcessor(PitchEstimationAlgorithm.YIN, 22050, 1024, pdh);
            dispatcher.addAudioProcessor(p);
            new Thread(dispatcher, "Audio Dispatcher").start();
    }

    private void checkPermissions() {
        boolean recordAudioPermissionGranted =
                ContextCompat.checkSelfPermission(this,
                        Manifest.permission.RECORD_AUDIO) +
                        ContextCompat.checkSelfPermission(this, Manifest.permission.VIBRATE)
                        == PackageManager.PERMISSION_GRANTED;
        if (recordAudioPermissionGranted) {
            start();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[] {Manifest.permission.VIBRATE, Manifest.permission.RECORD_AUDIO},
                    REQUEST_AUDIO);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        if (requestCode == REQUEST_AUDIO) {
            if (grantResults.length > 1 &&
                    grantResults[0] + grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                start();
            } else {
                // Permission has been denied before. At this point we should show a dialog to
                // user and explain why this permission is needed and direct him to go to the
                // Permissions settings for the app in the System settings. For this sample, we
                // simply exit to get to the important part.
                Toast.makeText(this, "EXITING", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        checkPermissions();
    }


}
