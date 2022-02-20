namespace Kursova_Rl_
{
    partial class FrmLogin
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmLogin));
            this.lblLoginAvt = new System.Windows.Forms.Label();
            this.lblPassAvt = new System.Windows.Forms.Label();
            this.txtBoxLoginAvt = new System.Windows.Forms.TextBox();
            this.txtBoxPassAvt = new System.Windows.Forms.TextBox();
            this.btnLoginAvt = new System.Windows.Forms.Button();
            this.btnBack = new Kursova_Rl_.Btn();
            this.SuspendLayout();
            // 
            // lblLoginAvt
            // 
            this.lblLoginAvt.AutoSize = true;
            this.lblLoginAvt.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblLoginAvt.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.lblLoginAvt.Location = new System.Drawing.Point(18, 25);
            this.lblLoginAvt.Name = "lblLoginAvt";
            this.lblLoginAvt.Size = new System.Drawing.Size(55, 21);
            this.lblLoginAvt.TabIndex = 0;
            this.lblLoginAvt.Text = "Логін";
            this.lblLoginAvt.Click += new System.EventHandler(this.lblLoginAvt_Click);
            // 
            // lblPassAvt
            // 
            this.lblPassAvt.AutoSize = true;
            this.lblPassAvt.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblPassAvt.ForeColor = System.Drawing.SystemColors.ActiveCaptionText;
            this.lblPassAvt.Location = new System.Drawing.Point(18, 82);
            this.lblPassAvt.Name = "lblPassAvt";
            this.lblPassAvt.Size = new System.Drawing.Size(69, 21);
            this.lblPassAvt.TabIndex = 1;
            this.lblPassAvt.Text = "Пароль";
            this.lblPassAvt.Click += new System.EventHandler(this.lblPassAvt_Click);
            // 
            // txtBoxLoginAvt
            // 
            this.txtBoxLoginAvt.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxLoginAvt.Location = new System.Drawing.Point(103, 22);
            this.txtBoxLoginAvt.MaxLength = 15;
            this.txtBoxLoginAvt.Name = "txtBoxLoginAvt";
            this.txtBoxLoginAvt.Size = new System.Drawing.Size(208, 34);
            this.txtBoxLoginAvt.TabIndex = 2;
            this.txtBoxLoginAvt.TextChanged += new System.EventHandler(this.txtBoxLoginAvt_TextChanged);
            this.txtBoxLoginAvt.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxLoginAvt_KeyPress);
            // 
            // txtBoxPassAvt
            // 
            this.txtBoxPassAvt.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxPassAvt.Location = new System.Drawing.Point(103, 79);
            this.txtBoxPassAvt.MaxLength = 15;
            this.txtBoxPassAvt.Name = "txtBoxPassAvt";
            this.txtBoxPassAvt.Size = new System.Drawing.Size(208, 34);
            this.txtBoxPassAvt.TabIndex = 3;
            this.txtBoxPassAvt.WordWrap = false;
            this.txtBoxPassAvt.TextChanged += new System.EventHandler(this.txtBoxPassAvt_TextChanged);
            this.txtBoxPassAvt.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxPassAvt_KeyPress);
            // 
            // btnLoginAvt
            // 
            this.btnLoginAvt.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnLoginAvt.Location = new System.Drawing.Point(116, 136);
            this.btnLoginAvt.Name = "btnLoginAvt";
            this.btnLoginAvt.Size = new System.Drawing.Size(165, 42);
            this.btnLoginAvt.TabIndex = 4;
            this.btnLoginAvt.Text = "Вхід";
            this.btnLoginAvt.UseVisualStyleBackColor = true;
            this.btnLoginAvt.Click += new System.EventHandler(this.btnLoginAvt_Click);
            // 
            // btnBack
            // 
            this.btnBack.BackgroundImage = ((System.Drawing.Image)(resources.GetObject("btnBack.BackgroundImage")));
            this.btnBack.BackgroundImageLayout = System.Windows.Forms.ImageLayout.Stretch;
            this.btnBack.FlatAppearance.BorderSize = 0;
            this.btnBack.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnBack.Location = new System.Drawing.Point(12, 136);
            this.btnBack.Name = "btnBack";
            this.btnBack.Size = new System.Drawing.Size(44, 46);
            this.btnBack.TabIndex = 8;
            this.btnBack.UseVisualStyleBackColor = true;
            this.btnBack.Click += new System.EventHandler(this.btnBack_Click);
            // 
            // FrmLogin
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(372, 223);
            this.ControlBox = false;
            this.Controls.Add(this.btnBack);
            this.Controls.Add(this.btnLoginAvt);
            this.Controls.Add(this.txtBoxPassAvt);
            this.Controls.Add(this.txtBoxLoginAvt);
            this.Controls.Add(this.lblPassAvt);
            this.Controls.Add(this.lblLoginAvt);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmLogin";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Вхід";
            this.TopMost = true;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmLogin_FormClosing);
            this.Load += new System.EventHandler(this.FrmLogin_Load);
            this.ResizeBegin += new System.EventHandler(this.FrmLogin_ResizeBegin);
            this.ResizeEnd += new System.EventHandler(this.FrmLogin_ResizeEnd);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblLoginAvt;
        private System.Windows.Forms.Label lblPassAvt;
        private System.Windows.Forms.TextBox txtBoxLoginAvt;
        private System.Windows.Forms.TextBox txtBoxPassAvt;
        private System.Windows.Forms.Button btnLoginAvt;
        private Btn btnBack;
    }
}