namespace Kursova_Rl_
{
    partial class FrmReg
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmReg));
            this.lblPIB = new System.Windows.Forms.Label();
            this.lblLogin = new System.Windows.Forms.Label();
            this.lblPass = new System.Windows.Forms.Label();
            this.txtBoxPIB = new System.Windows.Forms.TextBox();
            this.txtBoxLogin = new System.Windows.Forms.TextBox();
            this.txtBoxPass = new System.Windows.Forms.TextBox();
            this.btnReg = new System.Windows.Forms.Button();
            this.btnBack = new Kursova_Rl_.Btn();
            this.SuspendLayout();
            // 
            // lblPIB
            // 
            this.lblPIB.AutoSize = true;
            this.lblPIB.Location = new System.Drawing.Point(12, 17);
            this.lblPIB.Name = "lblPIB";
            this.lblPIB.Size = new System.Drawing.Size(74, 34);
            this.lblPIB.TabIndex = 0;
            this.lblPIB.Text = "Прізвище \r\nта ім\'я";
            // 
            // lblLogin
            // 
            this.lblLogin.AutoSize = true;
            this.lblLogin.Location = new System.Drawing.Point(12, 79);
            this.lblLogin.Name = "lblLogin";
            this.lblLogin.Size = new System.Drawing.Size(42, 17);
            this.lblLogin.TabIndex = 1;
            this.lblLogin.Text = "Логін";
            // 
            // lblPass
            // 
            this.lblPass.AutoSize = true;
            this.lblPass.Location = new System.Drawing.Point(12, 132);
            this.lblPass.Name = "lblPass";
            this.lblPass.Size = new System.Drawing.Size(57, 17);
            this.lblPass.TabIndex = 2;
            this.lblPass.Text = "Пароль";
            // 
            // txtBoxPIB
            // 
            this.txtBoxPIB.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxPIB.Location = new System.Drawing.Point(99, 21);
            this.txtBoxPIB.MaxLength = 21;
            this.txtBoxPIB.Name = "txtBoxPIB";
            this.txtBoxPIB.Size = new System.Drawing.Size(245, 34);
            this.txtBoxPIB.TabIndex = 3;
            this.txtBoxPIB.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxPIB_KeyPress);
            // 
            // txtBoxLogin
            // 
            this.txtBoxLogin.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxLogin.Location = new System.Drawing.Point(99, 76);
            this.txtBoxLogin.MaxLength = 15;
            this.txtBoxLogin.Name = "txtBoxLogin";
            this.txtBoxLogin.Size = new System.Drawing.Size(245, 34);
            this.txtBoxLogin.TabIndex = 4;
            this.txtBoxLogin.TextChanged += new System.EventHandler(this.txtBoxLogin_TextChanged);
            this.txtBoxLogin.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxLogin_KeyPress);
            // 
            // txtBoxPass
            // 
            this.txtBoxPass.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxPass.Location = new System.Drawing.Point(99, 129);
            this.txtBoxPass.MaxLength = 15;
            this.txtBoxPass.Name = "txtBoxPass";
            this.txtBoxPass.Size = new System.Drawing.Size(245, 34);
            this.txtBoxPass.TabIndex = 5;
            this.txtBoxPass.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxPass_KeyPress);
            // 
            // btnReg
            // 
            this.btnReg.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnReg.Location = new System.Drawing.Point(111, 182);
            this.btnReg.Name = "btnReg";
            this.btnReg.Size = new System.Drawing.Size(179, 53);
            this.btnReg.TabIndex = 6;
            this.btnReg.Text = "Реєстрація";
            this.btnReg.UseVisualStyleBackColor = true;
            this.btnReg.Click += new System.EventHandler(this.btnReg_Click);
            // 
            // btnBack
            // 
            this.btnBack.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnBack.BackgroundImage")));
            this.btnBack.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnBack.FlatAppearance.BorderSize = 0;
            this.btnBack.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBack.Location = new System.Drawing.Point(24, 188);
            this.btnBack.Name = "btnBack";
            this.btnBack.Size = new System.Drawing.Size(44, 46);
            this.btnBack.TabIndex = 7;
            this.btnBack.UseVisualStyleBackColor = true;
            this.btnBack.Click += new System.EventHandler(this.btnBack_Click);
            // 
            // FrmReg
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(371, 284);
            this.ControlBox = false;
            this.Controls.Add(this.btnBack);
            this.Controls.Add(this.btnReg);
            this.Controls.Add(this.txtBoxPass);
            this.Controls.Add(this.txtBoxLogin);
            this.Controls.Add(this.txtBoxPIB);
            this.Controls.Add(this.lblPass);
            this.Controls.Add(this.lblLogin);
            this.Controls.Add(this.lblPIB);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmReg";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Реєстрація";
            this.TopMost = true;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmReg_FormClosing);
            this.Load += new System.EventHandler(this.FrmReg_Load);
            this.ResizeBegin += new System.EventHandler(this.FrmReg_ResizeBegin);
            this.ResizeEnd += new System.EventHandler(this.FrmReg_ResizeEnd);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblPIB;
        private System.Windows.Forms.Label lblLogin;
        private System.Windows.Forms.Label lblPass;
        private System.Windows.Forms.TextBox txtBoxPIB;
        private System.Windows.Forms.TextBox txtBoxLogin;
        private System.Windows.Forms.TextBox txtBoxPass;
        private System.Windows.Forms.Button btnReg;
        private Btn btnBack;
    }
}