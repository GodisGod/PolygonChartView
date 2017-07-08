package com.example.hd.polygonchartview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private PolygonChartView polygonChartView;
    private SeekBar seekBarJisha;
    private SeekBar seekBarZhugong;
    private SeekBar seekBarWuli;
    private SeekBar seekBarMofa;
    private SeekBar seekBarJingQian;
    private SeekBar seekBarFangYu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        polygonChartView = (PolygonChartView) findViewById(R.id.polygon_view);
        seekBarJisha = (SeekBar) findViewById(R.id.seekbar_jisha);
        seekBarZhugong = (SeekBar) findViewById(R.id.seekbar_zhugong);
        seekBarWuli = (SeekBar) findViewById(R.id.seekbar_wuli);
        seekBarMofa = (SeekBar) findViewById(R.id.seekbar_mofa);
        seekBarFangYu = (SeekBar) findViewById(R.id.seekbar_fangyu);
        seekBarJingQian = (SeekBar) findViewById(R.id.seekbar_jinqian);

        seekBarJisha.setProgress(20);
        seekBarZhugong.setProgress(20);
        seekBarWuli.setProgress(20);
        seekBarMofa.setProgress(20);
        seekBarFangYu.setProgress(20);
        seekBarJingQian.setProgress(20);

        seekBarJisha.setOnSeekBarChangeListener(this);
        seekBarZhugong.setOnSeekBarChangeListener(this);
        seekBarWuli.setOnSeekBarChangeListener(this);
        seekBarMofa.setOnSeekBarChangeListener(this);
        seekBarJingQian.setOnSeekBarChangeListener(this);
        seekBarFangYu.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
        if (b) {
            switch (seekBar.getId()) {
                case R.id.seekbar_jisha:
                    polygonChartView.setJiSha(i);
                    break;
                case R.id.seekbar_zhugong:
                    polygonChartView.setZhuGong(i);
                    break;
                case R.id.seekbar_wuli:
                    polygonChartView.setWuli(i);
                    break;
                case R.id.seekbar_mofa:
                    polygonChartView.setMoFa(i);
                    break;
                case R.id.seekbar_jinqian:
                    polygonChartView.setFangYu(i);
                    break;
                case R.id.seekbar_fangyu:
                    polygonChartView.setJinQian(i);
                    break;
            }
        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

}
