namespace Kursova_Rl_
{
    partial class FrmTestRandom
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmTestRandom));
            this.player = new AxWMPLib.AxWindowsMediaPlayer();
            this.lblShow = new System.Windows.Forms.Label();
            this.btnNext = new System.Windows.Forms.Button();
            this.txtBoxRez = new System.Windows.Forms.TextBox();
            this.pctBoxFon = new System.Windows.Forms.PictureBox();
            this.btnBack = new Kursova_Rl_.Btn();
            ((System.ComponentModel.ISupportInitialize)(this.player)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBoxFon)).BeginInit();
            this.SuspendLayout();
            // 
            // player
            // 
            this.player.Enabled = true;
            this.player.Location = new System.Drawing.Point(292, 12);
            this.player.Name = "player";
            this.player.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("player.OcxState")));
            this.player.Size = new System.Drawing.Size(84, 40);
            this.player.TabIndex = 0;
            this.player.Visible = false;
            // 
            // lblShow
            // 
            this.lblShow.AutoSize = true;
            this.lblShow.BackColor = System.Drawing.Color.Transparent;
            this.lblShow.Font = new System.Drawing.Font("Monotype Corsiva", 48F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblShow.ForeColor = System.Drawing.Color.DarkMagenta;
            this.lblShow.Location = new System.Drawing.Point(83, 12);
            this.lblShow.Name = "lblShow";
            this.lblShow.Size = new System.Drawing.Size(154, 97);
            this.lblShow.TabIndex = 3;
            this.lblShow.Text = "2+2";
            // 
            // btnNext
            // 
            this.btnNext.BackColor = System.Drawing.Color.SpringGreen;
            this.btnNext.Font = new System.Drawing.Font("Times New Roman", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnNext.ForeColor = System.Drawing.Color.SeaGreen;
            this.btnNext.Location = new System.Drawing.Point(117, 201);
            this.btnNext.Name = "btnNext";
            this.btnNext.Size = new System.Drawing.Size(180, 50);
            this.btnNext.TabIndex = 4;
            this.btnNext.Text = "Далі";
            this.btnNext.UseVisualStyleBackColor = false;
            this.btnNext.Click += new System.EventHandler(this.button1_Click);
            // 
            // txtBoxRez
            // 
            this.txtBoxRez.BackColor = System.Drawing.Color.PeachPuff;
            this.txtBoxRez.Font = new System.Drawing.Font("Times New Roman", 16.2F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxRez.ForeColor = System.Drawing.Color.DarkMagenta;
            this.txtBoxRez.Location = new System.Drawing.Point(100, 158);
            this.txtBoxRez.Name = "txtBoxRez";
            this.txtBoxRez.Size = new System.Drawing.Size(218, 39);
            this.txtBoxRez.TabIndex = 5;
            this.txtBoxRez.TextChanged += new System.EventHandler(this.txtBoxRez_TextChanged);
            this.txtBoxRez.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxRez_KeyPress);
            // 
            // pctBoxFon
            // 
            this.pctBoxFon.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pctBoxFon.Location = new System.Drawing.Point(0, 0);
            this.pctBoxFon.Name = "pctBoxFon";
            this.pctBoxFon.Size = new System.Drawing.Size(388, 263);
            this.pctBoxFon.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctBoxFon.TabIndex = 7;
            this.pctBoxFon.TabStop = false;
            // 
            // btnBack
            // 
            this.btnBack.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnBack.BackgroundImage")));
            this.btnBack.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnBack.FlatAppearance.BorderSize = 0;
            this.btnBack.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBack.Location = new System.Drawing.Point(21, 201);
            this.btnBack.Name = "btnBack";
            this.btnBack.Size = new System.Drawing.Size(44, 46);
            this.btnBack.TabIndex = 8;
            this.btnBack.UseVisualStyleBackColor = true;
            this.btnBack.Click += new System.EventHandler(this.btnBack_Click);
            // 
            // FrmTestRandom
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.LightSalmon;
            this.ClientSize = new System.Drawing.Size(388, 263);
            this.ControlBox = false;
            this.Controls.Add(this.btnBack);
            this.Controls.Add(this.lblShow);
            this.Controls.Add(this.txtBoxRez);
            this.Controls.Add(this.btnNext);
            this.Controls.Add(this.player);
            this.Controls.Add(this.pctBoxFon);
            this.ForeColor = System.Drawing.Color.NavajoWhite;
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmTestRandom";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Тест";
            this.TopMost = true;
            this.Load += new System.EventHandler(this.frmTestRandom_Load);
            this.ResizeBegin += new System.EventHandler(this.FrmTestRandom_ResizeBegin);
            this.ResizeEnd += new System.EventHandler(this.FrmTestRandom_ResizeEnd);
            ((System.ComponentModel.ISupportInitialize)(this.player)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctBoxFon)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private AxWMPLib.AxWindowsMediaPlayer player;
        private System.Windows.Forms.Button btnNext;
        private System.Windows.Forms.Label lblShow;
        private System.Windows.Forms.TextBox txtBoxRez;
        private System.Windows.Forms.PictureBox pctBoxFon;
        private Btn btnBack;
    }
}