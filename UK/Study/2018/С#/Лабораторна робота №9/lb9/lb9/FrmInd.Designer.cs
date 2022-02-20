namespace lb9
{
    partial class FrmInd
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            System.Windows.Forms.DataVisualization.Charting.Series series2 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.lbl3 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl1 = new System.Windows.Forms.Label();
            this.Obrax = new System.Windows.Forms.Button();
            this.txtBoxSh = new System.Windows.Forms.TextBox();
            this.txtBoxXmax = new System.Windows.Forms.TextBox();
            this.txtBoxXmin = new System.Windows.Forms.TextBox();
            this.chart1 = new System.Windows.Forms.DataVisualization.Charting.Chart();
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).BeginInit();
            this.SuspendLayout();
            // 
            // lbl3
            // 
            this.lbl3.AutoSize = true;
            this.lbl3.Location = new System.Drawing.Point(399, 389);
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(32, 17);
            this.lbl3.TabIndex = 15;
            this.lbl3.Text = "Шаг";
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(259, 389);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(42, 17);
            this.lbl2.TabIndex = 14;
            this.lbl2.Text = "Xmax";
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(112, 389);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(39, 17);
            this.lbl1.TabIndex = 13;
            this.lbl1.Text = "Xmin";
            // 
            // Obrax
            // 
            this.Obrax.Location = new System.Drawing.Point(559, 398);
            this.Obrax.Name = "Obrax";
            this.Obrax.Size = new System.Drawing.Size(152, 32);
            this.Obrax.TabIndex = 12;
            this.Obrax.Text = "Обрахувати";
            this.Obrax.UseVisualStyleBackColor = true;
            this.Obrax.Click += new System.EventHandler(this.Obrax_Click);
            // 
            // txtBoxSh
            // 
            this.txtBoxSh.Location = new System.Drawing.Point(401, 409);
            this.txtBoxSh.Name = "txtBoxSh";
            this.txtBoxSh.Size = new System.Drawing.Size(99, 22);
            this.txtBoxSh.TabIndex = 11;
            // 
            // txtBoxXmax
            // 
            this.txtBoxXmax.Location = new System.Drawing.Point(262, 409);
            this.txtBoxXmax.Name = "txtBoxXmax";
            this.txtBoxXmax.Size = new System.Drawing.Size(99, 22);
            this.txtBoxXmax.TabIndex = 10;
            // 
            // txtBoxXmin
            // 
            this.txtBoxXmin.Location = new System.Drawing.Point(115, 409);
            this.txtBoxXmin.Name = "txtBoxXmin";
            this.txtBoxXmin.Size = new System.Drawing.Size(99, 22);
            this.txtBoxXmin.TabIndex = 9;
            // 
            // chart1
            // 
            chartArea1.Name = "ChartArea1";
            this.chart1.ChartAreas.Add(chartArea1);
            legend1.Name = "Legend1";
            this.chart1.Legends.Add(legend1);
            this.chart1.Location = new System.Drawing.Point(88, 20);
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
            this.chart1.TabIndex = 8;
            // 
            // FrmInd
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.lbl3);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.Obrax);
            this.Controls.Add(this.txtBoxSh);
            this.Controls.Add(this.txtBoxXmax);
            this.Controls.Add(this.txtBoxXmin);
            this.Controls.Add(this.chart1);
            this.Name = "FrmInd";
            this.Text = "FrmInd";
            ((System.ComponentModel.ISupportInitialize)(this.chart1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl3;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Button Obrax;
        private System.Windows.Forms.TextBox txtBoxSh;
        private System.Windows.Forms.TextBox txtBoxXmax;
        private System.Windows.Forms.TextBox txtBoxXmin;
        private System.Windows.Forms.DataVisualization.Charting.Chart chart1;
    }
}