namespace Kursova_Rl_
{
    partial class FrmConfig
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
            this.lblMin = new System.Windows.Forms.Label();
            this.lblMax = new System.Windows.Forms.Label();
            this.txtBoxMin = new System.Windows.Forms.TextBox();
            this.txtBoxMax = new System.Windows.Forms.TextBox();
            this.lblSteep = new System.Windows.Forms.Label();
            this.txtBoxSteep = new System.Windows.Forms.TextBox();
            this.lblDo = new System.Windows.Forms.Label();
            this.btnPoch = new System.Windows.Forms.Button();
            this.txtBoxKil = new System.Windows.Forms.TextBox();
            this.lblKil = new System.Windows.Forms.Label();
            this.rbPlus = new System.Windows.Forms.RadioButton();
            this.rbMinus = new System.Windows.Forms.RadioButton();
            this.rbMnoz = new System.Windows.Forms.RadioButton();
            this.rbDil = new System.Windows.Forms.RadioButton();
            this.btnClose = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // lblMin
            // 
            this.lblMin.AutoSize = true;
            this.lblMin.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblMin.Location = new System.Drawing.Point(12, 15);
            this.lblMin.Name = "lblMin";
            this.lblMin.Size = new System.Drawing.Size(177, 21);
            this.lblMin.TabIndex = 0;
            this.lblMin.Text = "Мінімальне значення";
            // 
            // lblMax
            // 
            this.lblMax.AutoSize = true;
            this.lblMax.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblMax.Location = new System.Drawing.Point(12, 58);
            this.lblMax.Name = "lblMax";
            this.lblMax.Size = new System.Drawing.Size(195, 21);
            this.lblMax.TabIndex = 1;
            this.lblMax.Text = "Максимальне значення";
            // 
            // txtBoxMin
            // 
            this.txtBoxMin.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxMin.Location = new System.Drawing.Point(213, 12);
            this.txtBoxMin.MaxLength = 3;
            this.txtBoxMin.Multiline = true;
            this.txtBoxMin.Name = "txtBoxMin";
            this.txtBoxMin.Size = new System.Drawing.Size(74, 32);
            this.txtBoxMin.TabIndex = 2;
            this.txtBoxMin.Text = "2";
            this.txtBoxMin.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxMin_KeyPress);
            // 
            // txtBoxMax
            // 
            this.txtBoxMax.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxMax.Location = new System.Drawing.Point(213, 50);
            this.txtBoxMax.MaxLength = 3;
            this.txtBoxMax.Multiline = true;
            this.txtBoxMax.Name = "txtBoxMax";
            this.txtBoxMax.Size = new System.Drawing.Size(74, 32);
            this.txtBoxMax.TabIndex = 3;
            this.txtBoxMax.Text = "100";
            this.txtBoxMax.TextChanged += new System.EventHandler(this.txtBoxMax_TextChanged);
            this.txtBoxMax.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxMax_KeyPress);
            // 
            // lblSteep
            // 
            this.lblSteep.AutoSize = true;
            this.lblSteep.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblSteep.Location = new System.Drawing.Point(331, 15);
            this.lblSteep.Name = "lblSteep";
            this.lblSteep.Size = new System.Drawing.Size(52, 21);
            this.lblSteep.TabIndex = 4;
            this.lblSteep.Text = "Крок";
            // 
            // txtBoxSteep
            // 
            this.txtBoxSteep.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxSteep.Location = new System.Drawing.Point(318, 47);
            this.txtBoxSteep.MaxLength = 3;
            this.txtBoxSteep.Multiline = true;
            this.txtBoxSteep.Name = "txtBoxSteep";
            this.txtBoxSteep.Size = new System.Drawing.Size(74, 32);
            this.txtBoxSteep.TabIndex = 5;
            this.txtBoxSteep.Text = "5";
            this.txtBoxSteep.TextChanged += new System.EventHandler(this.textBox3_TextChanged);
            this.txtBoxSteep.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxSteep_KeyPress);
            // 
            // lblDo
            // 
            this.lblDo.AutoSize = true;
            this.lblDo.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblDo.Location = new System.Drawing.Point(12, 170);
            this.lblDo.Name = "lblDo";
            this.lblDo.Size = new System.Drawing.Size(36, 21);
            this.lblDo.TabIndex = 6;
            this.lblDo.Text = "Дія";
            // 
            // btnPoch
            // 
            this.btnPoch.Location = new System.Drawing.Point(268, 128);
            this.btnPoch.Name = "btnPoch";
            this.btnPoch.Size = new System.Drawing.Size(115, 46);
            this.btnPoch.TabIndex = 11;
            this.btnPoch.Text = "Почати тест";
            this.btnPoch.UseVisualStyleBackColor = true;
            this.btnPoch.Click += new System.EventHandler(this.BtnPoch_Click);
            // 
            // txtBoxKil
            // 
            this.txtBoxKil.Font = new System.Drawing.Font("Times New Roman", 13.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.txtBoxKil.Location = new System.Drawing.Point(213, 88);
            this.txtBoxKil.MaxLength = 3;
            this.txtBoxKil.Multiline = true;
            this.txtBoxKil.Name = "txtBoxKil";
            this.txtBoxKil.Size = new System.Drawing.Size(74, 32);
            this.txtBoxKil.TabIndex = 13;
            this.txtBoxKil.Text = "5";
            this.txtBoxKil.KeyPress += new System.Windows.Forms.KeyPressEventHandler(this.txtBoxKil_KeyPress);
            // 
            // lblKil
            // 
            this.lblKil.AutoSize = true;
            this.lblKil.Font = new System.Drawing.Font("Times New Roman", 10.8F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblKil.Location = new System.Drawing.Point(12, 96);
            this.lblKil.Name = "lblKil";
            this.lblKil.Size = new System.Drawing.Size(144, 21);
            this.lblKil.TabIndex = 12;
            this.lblKil.Text = "Кількість питань";
            // 
            // rbPlus
            // 
            this.rbPlus.AutoSize = true;
            this.rbPlus.Location = new System.Drawing.Point(79, 132);
            this.rbPlus.Name = "rbPlus";
            this.rbPlus.Size = new System.Drawing.Size(103, 21);
            this.rbPlus.TabIndex = 14;
            this.rbPlus.TabStop = true;
            this.rbPlus.Text = "Додавання";
            this.rbPlus.UseVisualStyleBackColor = true;
            // 
            // rbMinus
            // 
            this.rbMinus.AutoSize = true;
            this.rbMinus.Location = new System.Drawing.Point(79, 159);
            this.rbMinus.Name = "rbMinus";
            this.rbMinus.Size = new System.Drawing.Size(101, 21);
            this.rbMinus.TabIndex = 15;
            this.rbMinus.TabStop = true;
            this.rbMinus.Text = "Віднімання";
            this.rbMinus.UseVisualStyleBackColor = true;
            // 
            // rbMnoz
            // 
            this.rbMnoz.AutoSize = true;
            this.rbMnoz.Checked = true;
            this.rbMnoz.Location = new System.Drawing.Point(79, 186);
            this.rbMnoz.Name = "rbMnoz";
            this.rbMnoz.Size = new System.Drawing.Size(97, 21);
            this.rbMnoz.TabIndex = 16;
            this.rbMnoz.TabStop = true;
            this.rbMnoz.Text = "Множення";
            this.rbMnoz.UseVisualStyleBackColor = true;
            // 
            // rbDil
            // 
            this.rbDil.AutoSize = true;
            this.rbDil.Location = new System.Drawing.Point(79, 211);
            this.rbDil.Name = "rbDil";
            this.rbDil.Size = new System.Drawing.Size(83, 21);
            this.rbDil.TabIndex = 17;
            this.rbDil.Text = "Ділення";
            this.rbDil.UseVisualStyleBackColor = true;
            // 
            // btnClose
            // 
            this.btnClose.DialogResult = System.Windows.Forms.DialogResult.Cancel;
            this.btnClose.Location = new System.Drawing.Point(268, 186);
            this.btnClose.Name = "btnClose";
            this.btnClose.Size = new System.Drawing.Size(115, 46);
            this.btnClose.TabIndex = 18;
            this.btnClose.Text = "Назад";
            this.btnClose.UseVisualStyleBackColor = true;
            this.btnClose.Click += new System.EventHandler(this.btnClose_Click);
            // 
            // FrmConfig
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(422, 272);
            this.ControlBox = false;
            this.Controls.Add(this.btnClose);
            this.Controls.Add(this.rbDil);
            this.Controls.Add(this.rbMnoz);
            this.Controls.Add(this.rbMinus);
            this.Controls.Add(this.rbPlus);
            this.Controls.Add(this.txtBoxKil);
            this.Controls.Add(this.lblKil);
            this.Controls.Add(this.btnPoch);
            this.Controls.Add(this.lblDo);
            this.Controls.Add(this.txtBoxSteep);
            this.Controls.Add(this.lblSteep);
            this.Controls.Add(this.txtBoxMax);
            this.Controls.Add(this.txtBoxMin);
            this.Controls.Add(this.lblMax);
            this.Controls.Add(this.lblMin);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "FrmConfig";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Конфігуратор";
            this.TopMost = true;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmConfig_FormClosing);
            this.Load += new System.EventHandler(this.FrmConfig_Load);
            this.ResizeBegin += new System.EventHandler(this.FrmConfig_ResizeBegin);
            this.ResizeEnd += new System.EventHandler(this.FrmConfig_ResizeEnd);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblMin;
        private System.Windows.Forms.Label lblMax;
        private System.Windows.Forms.TextBox txtBoxMin;
        private System.Windows.Forms.TextBox txtBoxMax;
        private System.Windows.Forms.Label lblSteep;
        private System.Windows.Forms.TextBox txtBoxSteep;
        private System.Windows.Forms.Label lblDo;
        private System.Windows.Forms.Button btnPoch;
        private System.Windows.Forms.TextBox txtBoxKil;
        private System.Windows.Forms.Label lblKil;
        private System.Windows.Forms.RadioButton rbPlus;
        private System.Windows.Forms.RadioButton rbMinus;
        private System.Windows.Forms.RadioButton rbMnoz;
        private System.Windows.Forms.RadioButton rbDil;
        private System.Windows.Forms.Button btnClose;
    }
}