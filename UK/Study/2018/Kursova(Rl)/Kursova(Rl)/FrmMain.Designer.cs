namespace Kursova_Rl_
{
    partial class FrmMain
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmMain));
            this.pctBoxFonMain = new System.Windows.Forms.PictureBox();
            this.lblMainNazv = new System.Windows.Forms.Label();
            this.lblVstup = new System.Windows.Forms.Label();
            this.btnExit = new Kursova_Rl_.Btn();
            this.btnLogin = new Kursova_Rl_.Btn();
            this.btnRegistration = new Kursova_Rl_.Btn();
            ((System.ComponentModel.ISupportInitialize)(this.pctBoxFonMain)).BeginInit();
            this.SuspendLayout();
            // 
            // pctBoxFonMain
            // 
            this.pctBoxFonMain.Dock = System.Windows.Forms.DockStyle.Fill;
            this.pctBoxFonMain.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.pctBoxFonMain.Location = new System.Drawing.Point(0, 0);
            this.pctBoxFonMain.Name = "pctBoxFonMain";
            this.pctBoxFonMain.Size = new System.Drawing.Size(1924, 1084);
            this.pctBoxFonMain.SizeMode = System.Windows.Forms.PictureBoxSizeMode.StretchImage;
            this.pctBoxFonMain.TabIndex = 1;
            this.pctBoxFonMain.TabStop = false;
            // 
            // lblMainNazv
            // 
            this.lblMainNazv.BackColor = System.Drawing.SystemColors.Control;
            this.lblMainNazv.Font = new System.Drawing.Font("Monotype Corsiva", 60F, ((System.Drawing.FontStyle)((System.Drawing.FontStyle.Italic | System.Drawing.FontStyle.Underline))));
            this.lblMainNazv.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.lblMainNazv.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.lblMainNazv.Location = new System.Drawing.Point(399, 197);
            this.lblMainNazv.Name = "lblMainNazv";
            this.lblMainNazv.Size = new System.Drawing.Size(293, 69);
            this.lblMainNazv.TabIndex = 3;
            this.lblMainNazv.Text = "Математичний\r\nдиктант";
            this.lblMainNazv.TextAlign = System.Drawing.ContentAlignment.MiddleCenter;
            // 
            // lblVstup
            // 
            this.lblVstup.AutoSize = true;
            this.lblVstup.Dock = System.Windows.Forms.DockStyle.Left;
            this.lblVstup.Font = new System.Drawing.Font("Monotype Corsiva", 36F, System.Drawing.FontStyle.Italic);
            this.lblVstup.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.lblVstup.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.lblVstup.Location = new System.Drawing.Point(0, 0);
            this.lblVstup.Name = "lblVstup";
            this.lblVstup.Size = new System.Drawing.Size(1196, 864);
            this.lblVstup.TabIndex = 5;
            this.lblVstup.Text = resources.GetString("lblVstup.Text");
            this.lblVstup.Click += new System.EventHandler(this.lblVstup_Click);
            // 
            // btnExit
            // 
            this.btnExit.BackColor = System.Drawing.Color.Orchid;
            this.btnExit.FlatAppearance.BorderSize = 0;
            this.btnExit.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnExit.Font = new System.Drawing.Font("Times New Roman", 25.8F, System.Drawing.FontStyle.Bold);
            this.btnExit.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnExit.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.btnExit.Location = new System.Drawing.Point(1537, 622);
            this.btnExit.Name = "btnExit";
            this.btnExit.Size = new System.Drawing.Size(265, 123);
            this.btnExit.TabIndex = 13;
            this.btnExit.Text = "Вихід";
            this.btnExit.UseVisualStyleBackColor = false;
            this.btnExit.Click += new System.EventHandler(this.btn1_Click);
            this.btnExit.MouseEnter += new System.EventHandler(this.btnExit_MouseEnter_1);
            this.btnExit.MouseLeave += new System.EventHandler(this.btnExit_MouseLeave);
            // 
            // btnLogin
            // 
            this.btnLogin.BackColor = System.Drawing.Color.Orchid;
            this.btnLogin.FlatAppearance.BorderSize = 0;
            this.btnLogin.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnLogin.Font = new System.Drawing.Font("Times New Roman", 25.8F, System.Drawing.FontStyle.Bold);
            this.btnLogin.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnLogin.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.btnLogin.Location = new System.Drawing.Point(1537, 473);
            this.btnLogin.Name = "btnLogin";
            this.btnLogin.Size = new System.Drawing.Size(265, 123);
            this.btnLogin.TabIndex = 11;
            this.btnLogin.Text = "Вхід";
            this.btnLogin.UseVisualStyleBackColor = false;
            this.btnLogin.Click += new System.EventHandler(this.btnLogin_Click);
            this.btnLogin.MouseEnter += new System.EventHandler(this.btnLogin_MouseEnter);
            this.btnLogin.MouseLeave += new System.EventHandler(this.btnLogin_MouseLeave);
            this.btnLogin.Move += new System.EventHandler(this.btnRegistration_Move);
            // 
            // btnRegistration
            // 
            this.btnRegistration.BackColor = System.Drawing.Color.Orchid;
            this.btnRegistration.FlatAppearance.BorderSize = 0;
            this.btnRegistration.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnRegistration.Font = new System.Drawing.Font("Times New Roman", 25.8F, System.Drawing.FontStyle.Bold);
            this.btnRegistration.ForeColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnRegistration.ImeMode = System.Windows.Forms.ImeMode.NoControl;
            this.btnRegistration.Location = new System.Drawing.Point(1537, 318);
            this.btnRegistration.Name = "btnRegistration";
            this.btnRegistration.Size = new System.Drawing.Size(265, 123);
            this.btnRegistration.TabIndex = 10;
            this.btnRegistration.Text = "Реєстрація";
            this.btnRegistration.UseVisualStyleBackColor = false;
            this.btnRegistration.Click += new System.EventHandler(this.btnRegistration_Click);
            this.btnRegistration.MouseEnter += new System.EventHandler(this.btnRegistration_MouseEnter);
            this.btnRegistration.MouseLeave += new System.EventHandler(this.btnRegistration_MouseLeave);
            this.btnRegistration.Move += new System.EventHandler(this.btnRegistration_Move);
            // 
            // FrmMain
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSize = true;
            this.ClientSize = new System.Drawing.Size(1924, 1084);
            this.ControlBox = false;
            this.Controls.Add(this.btnExit);
            this.Controls.Add(this.btnLogin);
            this.Controls.Add(this.btnRegistration);
            this.Controls.Add(this.lblVstup);
            this.Controls.Add(this.lblMainNazv);
            this.Controls.Add(this.pctBoxFonMain);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.SizableToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.IsMdiContainer = true;
            this.Location = new System.Drawing.Point(638, 0);
            this.Name = "FrmMain";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.TopMost = true;
            this.TransparencyKey = System.Drawing.Color.DarkRed;
            this.WindowState = System.Windows.Forms.FormWindowState.Maximized;
            this.Load += new System.EventHandler(this.FrmMain_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pctBoxFonMain)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.PictureBox pctBoxFonMain;
        private System.Windows.Forms.Label lblMainNazv;
        private System.Windows.Forms.Label lblVstup;
        private Btn btnRegistration;
        private Btn btnLogin;
        private Btn btnExit;
    }
}

