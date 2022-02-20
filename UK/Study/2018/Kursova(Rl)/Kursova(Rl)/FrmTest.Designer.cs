namespace Kursova_Rl_
{
    partial class FrmTest
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
            System.ComponentModel.ComponentResourceManager resources = new System.ComponentModel.ComponentResourceManager(typeof(FrmTest));
            this.rb4 = new System.Windows.Forms.RadioButton();
            this.rb3 = new System.Windows.Forms.RadioButton();
            this.rb2 = new System.Windows.Forms.RadioButton();
            this.rb1 = new System.Windows.Forms.RadioButton();
            this.lblvopros = new System.Windows.Forms.Label();
            this.btnNext = new Kursova_Rl_.Btn();
            this.player = new AxWMPLib.AxWindowsMediaPlayer();
            ((System.ComponentModel.ISupportInitialize)(this.player)).BeginInit();
            this.SuspendLayout();
            // 
            // rb4
            // 
            this.rb4.AutoSize = true;
            this.rb4.Font = new System.Drawing.Font("Tahoma", 9.75F);
            this.rb4.Location = new System.Drawing.Point(34, 198);
            this.rb4.Name = "rb4";
            this.rb4.Size = new System.Drawing.Size(137, 25);
            this.rb4.TabIndex = 9;
            this.rb4.Text = "Відповідь №4";
            this.rb4.UseVisualStyleBackColor = true;
            // 
            // rb3
            // 
            this.rb3.AutoSize = true;
            this.rb3.Font = new System.Drawing.Font("Tahoma", 9.75F);
            this.rb3.Location = new System.Drawing.Point(34, 155);
            this.rb3.Name = "rb3";
            this.rb3.Size = new System.Drawing.Size(137, 25);
            this.rb3.TabIndex = 8;
            this.rb3.Text = "Відповідь №3";
            this.rb3.UseVisualStyleBackColor = true;
            // 
            // rb2
            // 
            this.rb2.AutoSize = true;
            this.rb2.Font = new System.Drawing.Font("Tahoma", 9.75F);
            this.rb2.Location = new System.Drawing.Point(34, 115);
            this.rb2.Name = "rb2";
            this.rb2.Size = new System.Drawing.Size(137, 25);
            this.rb2.TabIndex = 7;
            this.rb2.Text = "Відповідь №2";
            this.rb2.UseVisualStyleBackColor = true;
            // 
            // rb1
            // 
            this.rb1.AutoSize = true;
            this.rb1.Font = new System.Drawing.Font("Tahoma", 9.75F);
            this.rb1.Location = new System.Drawing.Point(34, 76);
            this.rb1.Name = "rb1";
            this.rb1.Size = new System.Drawing.Size(137, 25);
            this.rb1.TabIndex = 6;
            this.rb1.Text = "Відповідь №1";
            this.rb1.UseVisualStyleBackColor = true;
            // 
            // lblvopros
            // 
            this.lblvopros.AutoSize = true;
            this.lblvopros.Font = new System.Drawing.Font("Tahoma", 15F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.lblvopros.Location = new System.Drawing.Point(12, 25);
            this.lblvopros.Name = "lblvopros";
            this.lblvopros.Size = new System.Drawing.Size(119, 30);
            this.lblvopros.TabIndex = 5;
            this.lblvopros.Text = "Питання:";
            // 
            // btnNext
            // 
            this.btnNext.BackColor = System.Drawing.Color.LightPink;
            this.btnNext.FlatAppearance.BorderColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnNext.FlatAppearance.BorderSize = 0;
            this.btnNext.FlatAppearance.MouseDownBackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnNext.FlatAppearance.MouseOverBackColor = System.Drawing.SystemColors.ButtonHighlight;
            this.btnNext.FlatStyle = System.Windows.Forms.FlatStyle.Flat;
            this.btnNext.Font = new System.Drawing.Font("Times New Roman", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(204)));
            this.btnNext.Location = new System.Drawing.Point(372, 234);
            this.btnNext.Name = "btnNext";
            this.btnNext.Size = new System.Drawing.Size(143, 75);
            this.btnNext.TabIndex = 10;
            this.btnNext.Text = "Далі";
            this.btnNext.UseVisualStyleBackColor = false;
            this.btnNext.Click += new System.EventHandler(this.btnNext_Click);
            // 
            // player
            // 
            this.player.Enabled = true;
            this.player.Location = new System.Drawing.Point(391, 30);
            this.player.Name = "player";
            this.player.OcxState = ((System.Windows.Forms.AxHost.State)(resources.GetObject("player.OcxState")));
            this.player.Size = new System.Drawing.Size(123, 46);
            this.player.TabIndex = 11;
            this.player.Visible = false;
            // 
            // FrmTest
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(538, 321);
            this.ControlBox = false;
            this.Controls.Add(this.player);
            this.Controls.Add(this.btnNext);
            this.Controls.Add(this.rb4);
            this.Controls.Add(this.rb3);
            this.Controls.Add(this.rb2);
            this.Controls.Add(this.rb1);
            this.Controls.Add(this.lblvopros);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Icon = ((System.Drawing.Icon)(resources.GetObject("$this.Icon")));
            this.Name = "FrmTest";
            this.StartPosition = System.Windows.Forms.FormStartPosition.CenterScreen;
            this.Text = "Тест";
            this.TopMost = true;
            this.FormClosing += new System.Windows.Forms.FormClosingEventHandler(this.FrmTest_FormClosing);
            this.Load += new System.EventHandler(this.FrmTest_Load);
            ((System.ComponentModel.ISupportInitialize)(this.player)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.RadioButton rb4;
        private System.Windows.Forms.RadioButton rb3;
        private System.Windows.Forms.RadioButton rb2;
        private System.Windows.Forms.RadioButton rb1;
        private System.Windows.Forms.Label lblvopros;
        private Btn btnNext;
        private AxWMPLib.AxWindowsMediaPlayer player;
    }
}