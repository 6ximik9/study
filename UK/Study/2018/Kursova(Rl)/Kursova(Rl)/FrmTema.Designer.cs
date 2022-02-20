namespace Kursova_Rl_
{
    partial class FrmTema
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmTema));
            this.lblTemaShow = new System.Windows.Forms.Label();
            this.pctBox01 = new System.Windows.Forms.PictureBox();
            this.pctBox02 = new System.Windows.Forms.PictureBox();
            this.pctBox03 = new System.Windows.Forms.PictureBox();
            ((System.ComponentModel.ISupportInitialize)(this.pctBox01)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBox02)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBox03)).BeginInit();
            this.SuspendLayout();
            // 
            // lblTemaShow
            // 
            this.lblTemaShow.AutoSize = true;
            this.lblTemaShow.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblTemaShow.Location = new System.Drawing.Point(11, 12);
            this.lblTemaShow.Name = "lblTemaShow";
            this.lblTemaShow.Size = new System.Drawing.Size(70, 27);
            this.lblTemaShow.TabIndex = 0;
            this.lblTemaShow.Text = "label1";
            // 
            // pctBox01
            // 
            this.pctBox01.Location = new System.Drawing.Point(12, 210);
            this.pctBox01.Name = "pctBox01";
            this.pctBox01.Size = new System.Drawing.Size(715, 377);
            this.pctBox01.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctBox01.TabIndex = 1;
            this.pctBox01.TabStop = false;
            // 
            // pctBox02
            // 
            this.pctBox02.Location = new System.Drawing.Point(1187, 210);
            this.pctBox02.Name = "pctBox02";
            this.pctBox02.Size = new System.Drawing.Size(715, 377);
            this.pctBox02.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctBox02.TabIndex = 2;
            this.pctBox02.TabStop = false;
            // 
            // pctBox03
            // 
            this.pctBox03.Location = new System.Drawing.Point(1187, 933);
            this.pctBox03.Name = "pctBox03";
            this.pctBox03.Size = new System.Drawing.Size(715, 377);
            this.pctBox03.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctBox03.TabIndex = 3;
            this.pctBox03.TabStop = false;
            // 
            // FrmTema
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoScroll = true;
            this.ClientSize = new System.Drawing.Size(1308, 656);
            this.Controls.Add(this.pctBox03);
            this.Controls.Add(this.pctBox02);
            this.Controls.Add(this.pctBox01);
            this.Controls.Add(this.lblTemaShow);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmTema";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.TopMost = true;
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmTema_FormClosing);
            this.Load += new System.EventHandler(this.FrmTema_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pctBox01)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBox02)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBox03)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblTemaShow;
        private System.Windows.Forms.PictureBox pctBox01;
        private System.Windows.Forms.PictureBox pctBox02;
        private System.Windows.Forms.PictureBox pctBox03;
    }
}