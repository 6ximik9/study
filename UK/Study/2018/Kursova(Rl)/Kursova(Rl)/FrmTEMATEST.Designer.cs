namespace Kursova_Rl_
{
    partial class FrmTEMATEST
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
            this.components = new System.ComponentModel.Container();
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmTEMATEST));
            this.btnZm = new System.Windows.Forms.Button();
            this.tlTipSet = new System.Windows.Forms.ToolTip(this.components);
            this.btnRezult = new System.Windows.Forms.Button();
            this.pnlThemes = new System.Windows.Forms.Panel();
            this.pctThemes = new System.Windows.Forms.PictureBox();
            this.lbl1 = new System.Windows.Forms.Label();
            this.btnPochTema = new System.Windows.Forms.Button();
            this.btnPochTest = new System.Windows.Forms.Button();
            this.lblPIB = new System.Windows.Forms.Label();
            this.Pleas = new System.Windows.Forms.Label();
            this.btnExit = new System.Windows.Forms.Button();
            this.btnCance = new System.Windows.Forms.Button();
            this.pctFon = new System.Windows.Forms.PictureBox();
            this.btnRandomTest = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.pctThemes)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctFon)).BeginInit();
            this.SuspendLayout();
            // 
            // btnZm
            // 
            this.btnZm.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnZm.BackgroundImage")));
            this.btnZm.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnZm.Location = new System.Drawing.Point(12, 2);
            this.btnZm.Name = "btnZm";
            this.btnZm.Size = new System.Drawing.Size(65, 57);
            this.btnZm.TabIndex = 14;
            this.tlTipSet.SetToolTip(this.btnZm, "Клікніть лівою кнопкою мишки \r\nщоб додати нову тему\r\nP.s. Вийдіть з програми для " +
        "внесення змін\r\n\r\n");
            this.btnZm.UseVisualStyleBackColor = true;
            this.btnZm.Click += new System.EventHandler(this.btnZm_Click);
            // 
            // btnRezult
            // 
            this.btnRezult.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnRezult.BackgroundImage")));
            this.btnRezult.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnRezult.Location = new System.Drawing.Point(83, 2);
            this.btnRezult.Name = "btnRezult";
            this.btnRezult.Size = new System.Drawing.Size(61, 57);
            this.btnRezult.TabIndex = 15;
            this.tlTipSet.SetToolTip(this.btnRezult, "Клікніть лівою кнопкою миші\r\nщоб переглянути результи");
            this.btnRezult.UseVisualStyleBackColor = true;
            this.btnRezult.Click += new System.EventHandler(this.btnRezult_Click);
            // 
            // pnlThemes
            // 
            this.pnlThemes.AutoScroll = true;
            this.pnlThemes.Location = new System.Drawing.Point(12, 95);
            this.pnlThemes.Name = "pnlThemes";
            this.pnlThemes.Size = new System.Drawing.Size(728, 395);
            this.pnlThemes.TabIndex = 16;
            this.pnlThemes.Paint += new System.Windows.Forms.PaintEventHandler(this.pnlThemes_Paint);
            // 
            // pctThemes
            // 
            this.pctThemes.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.pctThemes.Location = new System.Drawing.Point(759, 95);
            this.pctThemes.Name = "pctThemes";
            this.pctThemes.Size = new System.Drawing.Size(414, 395);
            this.pctThemes.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctThemes.TabIndex = 17;
            this.pctThemes.TabStop = false;
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Font = new System.Drawing.Font("Microsoft YaHei UI", 18F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lbl1.Location = new System.Drawing.Point(189, 10);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(0, 40);
            this.lbl1.TabIndex = 18;
            // 
            // btnPochTema
            // 
            this.btnPochTema.BackColor = System.Drawing.Color.Crimson;
            this.btnPochTema.Font = new System.Drawing.Font("Monotype Corsiva", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnPochTema.Location = new System.Drawing.Point(852, 10);
            this.btnPochTema.Name = "btnPochTema";
            this.btnPochTema.Size = new System.Drawing.Size(100, 64);
            this.btnPochTema.TabIndex = 19;
            this.btnPochTema.Text = "Вивчити тему";
            this.btnPochTema.UseVisualStyleBackColor = false;
            this.btnPochTema.Click += new System.EventHandler(this.btnPochTema_Click_1);
            // 
            // btnPochTest
            // 
            this.btnPochTest.BackColor = System.Drawing.Color.Crimson;
            this.btnPochTest.Font = new System.Drawing.Font("Monotype Corsiva", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnPochTest.Location = new System.Drawing.Point(958, 10);
            this.btnPochTest.Name = "btnPochTest";
            this.btnPochTest.Size = new System.Drawing.Size(95, 64);
            this.btnPochTest.TabIndex = 20;
            this.btnPochTest.Text = "Пройти тест";
            this.btnPochTest.UseVisualStyleBackColor = false;
            this.btnPochTest.Click += new System.EventHandler(this.btnPochTest_Click);
            // 
            // lblPIB
            // 
            this.lblPIB.AutoSize = true;
            this.lblPIB.Font = new System.Drawing.Font("Monotype Corsiva", 22.2F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblPIB.Location = new System.Drawing.Point(476, 498);
            this.lblPIB.Name = "lblPIB";
            this.lblPIB.Size = new System.Drawing.Size(0, 46);
            this.lblPIB.TabIndex = 21;
            // 
            // Pleas
            // 
            this.Pleas.AutoSize = true;
            this.Pleas.Font = new System.Drawing.Font("Monotype Corsiva", 16.2F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.Pleas.ForeColor = System.Drawing.Color.Red;
            this.Pleas.Location = new System.Drawing.Point(30, 71);
            this.Pleas.Name = "Pleas";
            this.Pleas.Size = new System.Drawing.Size(273, 34);
            this.Pleas.TabIndex = 22;
            this.Pleas.Text = "Будь ласка оберіть тему";
            // 
            // btnExit
            // 
            this.btnExit.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(128)))), ((int)(((byte)(128)))));
            this.btnExit.Font = new System.Drawing.Font("Monotype Corsiva", 13.8F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnExit.Location = new System.Drawing.Point(1041, 509);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(132, 35);
            this.btnExit.TabIndex = 23;
            this.btnExit.Text = "Вихід";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btnExit_Click);
            // 
            // btnCance
            // 
            this.btnCance.BackColor = System.Drawing.Color.Pink;
            this.btnCance.Font = new System.Drawing.Font("Monotype Corsiva", 13.8F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnCance.Location = new System.Drawing.Point(12, 510);
            this.btnCance.Name = "btnCance";
            this.btnCance.Size = new System.Drawing.Size(201, 35);
            this.btnCance.TabIndex = 24;
            this.btnCance.Text = "Відмінити вибір";
            this.btnCance.UseVisualStyleBackColor = false;
            this.btnCance.Click += new System.EventHandler(this.btnCance_Click);
            // 
            // pctFon
            // 
            this.pctFon.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pctFon.Location = new System.Drawing.Point(0, 0);
            this.pctFon.Name = "pctFon";
            this.pctFon.Size = new System.Drawing.Size(1209, 592);
            this.pctFon.TabIndex = 25;
            this.pctFon.TabStop = false;
            this.pctFon.Click += new System.EventHandler(this.pctFon_Click);
            // 
            // btnRandomTest
            // 
            this.btnRandomTest.BackColor = System.Drawing.Color.Lime;
            this.btnRandomTest.Font = new System.Drawing.Font("Monotype Corsiva", 12F, System.Drawing.FontStyle.Italic, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnRandomTest.Location = new System.Drawing.Point(1059, 10);
            this.btnRandomTest.Name = "btnRandomTest";
            this.btnRandomTest.Size = new System.Drawing.Size(124, 64);
            this.btnRandomTest.TabIndex = 26;
            this.btnRandomTest.Text = "Згенерувати тест";
            this.btnRandomTest.UseVisualStyleBackColor = false;
            this.btnRandomTest.Click += new System.EventHandler(this.btnRandomTest_Click);
            // 
            // FrmTEMATEST
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.Color.FromArgb(((int)(((byte)(255)))), ((int)(((byte)(255)))), ((int)(((byte)(192)))));
            this.ClientSize = new System.Drawing.Size(1209, 592);
            this.ControlBox = false;
            this.Controls.Add(this.btnRandomTest);
            this.Controls.Add(this.btnCance);
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.Pleas);
            this.Controls.Add(this.lblPIB);
            this.Controls.Add(this.btnPochTest);
            this.Controls.Add(this.btnPochTema);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.pctThemes);
            this.Controls.Add(this.pnlThemes);
            this.Controls.Add(this.btnRezult);
            this.Controls.Add(this.btnZm);
            this.Controls.Add(this.pctFon);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmTEMATEST";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Математиний диктант";
            this.TopMost = true;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmTEMATEST_FormClosing);
            this.Load += new System.EventHandler(this.FrmTEMATEST_Load);
            this.ResizeBegin += new System.EventHandler(this.FrmTEMATEST_ResizeBegin);
            this.ResizeEnd += new System.EventHandler(this.FrmTEMATEST_ResizeEnd);
            ((System.ComponentModel.ISupportInitialize)(this.pctThemes)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.pctFon)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion
        private System.Windows.Forms.Button btnZm;
        private System.Windows.Forms.ToolTip tlTipSet;
        private System.Windows.Forms.Button btnRezult;
        private System.Windows.Forms.Panel pnlThemes;
        private System.Windows.Forms.PictureBox pctThemes;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Button btnPochTema;
        private System.Windows.Forms.Button btnPochTest;
        private System.Windows.Forms.Label lblPIB;
        private System.Windows.Forms.Label Pleas;
        private System.Windows.Forms.Button btnExit;
        private System.Windows.Forms.Button btnCance;
        private System.Windows.Forms.PictureBox pctFon;
        private System.Windows.Forms.Button btnRandomTest;
    }
}