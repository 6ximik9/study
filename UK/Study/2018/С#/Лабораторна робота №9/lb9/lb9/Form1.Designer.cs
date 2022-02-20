namespace lb9
{
    partial class Form1
    {
        /// <summary>
        /// Обязательная переменная конструктора.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Освободить все используемые ресурсы.
        /// </summary>
        /// <param name="disposing">истинно, если управляемый ресурс должен быть удален; иначе ложно.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Код, автоматически созданный конструктором форм Windows

        /// <summary>
        /// Требуемый метод для поддержки конструктора — не изменяйте 
        /// содержимое этого метода с помощью редактора кода.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.txtBoxXmin = new System.Windows.Forms.TextBox();
            this.txtBoxXmax = new System.Windows.Forms.TextBox();
            this.txtBoxSh = new System.Windows.Forms.TextBox();
            this.Obrax = new System.Windows.Forms.Button();
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl3 = new System.Windows.Forms.Label();
            this.button1 = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            this.SuspendLayout();
            // 
            // chart1
            // 
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.chart1.Legends.Add(legend1);
            this.chart1.Location = new System.Drawing.Point(66, 27);
            this.chart1.Name = "chart1";
            this.chart1.Palette = System.Windows.Forms.DataVisualization.Charting.ChartColorPalette.Berry;
            series1.BorderWidth = 3;
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Spline;
            series1.Color = System.Drawing.Color.Red;
            series1.Legend = "Legend1";
            series1.LegendText = "sin(x)";
            series1.Name = "Series0";
            series2.BorderWidth = 3;
            series2.ChartArea = "ChartArea1";
            series2.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Spline;
            series2.Color = System.Drawing.Color.Fuchsia;
            series2.Legend = "Legend1";
            series2.LegendText = "cos(x)";
            series2.Name = "Series1";
            this.chart1.Series.Add(series1);
            this.chart1.Series.Add(series2);
            this.chart1.Size = new System.Drawing.Size(624, 349);
            this.chart1.TabIndex = 0;
            this.chart1.Click += new System.EventHandler(this.chart1_Click);
            // 
            // txtBoxXmin
            // 
            this.txtBoxXmin.Location = new System.Drawing.Point(93, 416);
            this.txtBoxXmin.Name = "txtBoxXmin";
            this.txtBoxXmin.Size = new System.Drawing.Size(99, 22);
            this.txtBoxXmin.TabIndex = 1;
            // 
            // txtBoxXmax
            // 
            this.txtBoxXmax.Location = new System.Drawing.Point(240, 416);
            this.txtBoxXmax.Name = "txtBoxXmax";
            this.txtBoxXmax.Size = new System.Drawing.Size(99, 22);
            this.txtBoxXmax.TabIndex = 2;
            // 
            // txtBoxSh
            // 
            this.txtBoxSh.Location = new System.Drawing.Point(379, 416);
            this.txtBoxSh.Name = "txtBoxSh";
            this.txtBoxSh.Size = new System.Drawing.Size(99, 22);
            this.txtBoxSh.TabIndex = 3;
            // 
            // Obrax
            // 
            this.Obrax.Location = new System.Drawing.Point(537, 405);
            this.Obrax.Name = "Obrax";
            this.Obrax.Size = new System.Drawing.Size(152, 32);
            this.Obrax.TabIndex = 4;
            this.Obrax.Text = "Обрахувати";
            this.Obrax.UseVisualStyleBackColor = true;
            this.Obrax.Click += new System.EventHandler(this.Obrax_Click);
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(90, 396);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(39, 17);
            this.lbl1.TabIndex = 5;
            this.lbl1.Text = "Xmin";
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(237, 396);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(42, 17);
            this.lbl2.TabIndex = 6;
            this.lbl2.Text = "Xmax";
            // 
            // lbl3
            // 
            this.lbl3.AutoSize = true;
            this.lbl3.Location = new System.Drawing.Point(377, 396);
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(32, 17);
            this.lbl3.TabIndex = 7;
            this.lbl3.Text = "Шаг";
            // 
            // button1
            // 
            this.button1.Location = new System.Drawing.Point(714, 220);
            this.button1.Name = "button1";
            this.button1.Size = new System.Drawing.Size(64, 51);
            this.button1.TabIndex = 8;
            this.button1.Text = "Ind";
            this.button1.UseVisualStyleBackColor = true;
            this.button1.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.button1);
            this.Controls.Add(this.lbl3);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.Obrax);
            this.Controls.Add(this.txtBoxSh);
            this.Controls.Add(this.txtBoxXmax);
            this.Controls.Add(this.txtBoxXmin);
            this.Controls.Add(this.chart1);
            this.Name = "Form1";
            this.Text = "Лабораторна робота №9";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
        private System.Windows.Forms.TextBox txtBoxXmin;
        private System.Windows.Forms.TextBox txtBoxXmax;
        private System.Windows.Forms.TextBox txtBoxSh;
        private System.Windows.Forms.Button Obrax;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl3;
        private System.Windows.Forms.Button button1;
    }
}

