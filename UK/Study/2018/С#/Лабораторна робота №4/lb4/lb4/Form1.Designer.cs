namespace lb4
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
            this.txtbox1 = new System.Windows.Forms.TextBox();
            this.txtbox2 = new System.Windows.Forms.TextBox();
            this.txtbox3 = new System.Windows.Forms.TextBox();
            this.txtbox4 = new System.Windows.Forms.TextBox();
            this.txtbox5 = new System.Windows.Forms.TextBox();
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lbl3 = new System.Windows.Forms.Label();
            this.lbl4 = new System.Windows.Forms.Label();
            this.btn1 = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txtbox1
            // 
            this.txtbox1.Location = new System.Drawing.Point(85, 15);
            this.txtbox1.Name = "txtbox1";
            this.txtbox1.Size = new System.Drawing.Size(108, 22);
            this.txtbox1.TabIndex = 0;
            // 
            // txtbox2
            // 
            this.txtbox2.Location = new System.Drawing.Point(85, 54);
            this.txtbox2.Name = "txtbox2";
            this.txtbox2.Size = new System.Drawing.Size(108, 22);
            this.txtbox2.TabIndex = 1;
            // 
            // txtbox3
            // 
            this.txtbox3.Location = new System.Drawing.Point(85, 101);
            this.txtbox3.Name = "txtbox3";
            this.txtbox3.Size = new System.Drawing.Size(108, 22);
            this.txtbox3.TabIndex = 2;
            // 
            // txtbox4
            // 
            this.txtbox4.Location = new System.Drawing.Point(85, 140);
            this.txtbox4.Name = "txtbox4";
            this.txtbox4.Size = new System.Drawing.Size(108, 22);
            this.txtbox4.TabIndex = 3;
            // 
            // txtbox5
            // 
            this.txtbox5.Location = new System.Drawing.Point(12, 187);
            this.txtbox5.Multiline = true;
            this.txtbox5.Name = "txtbox5";
            this.txtbox5.Size = new System.Drawing.Size(276, 224);
            this.txtbox5.TabIndex = 4;
            this.txtbox5.TextChanged += new System.EventHandler(this.txtbox5_TextChanged);
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(12, 15);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(25, 17);
            this.lbl1.TabIndex = 5;
            this.lbl1.Text = "X0";
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(13, 54);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(24, 17);
            this.lbl2.TabIndex = 6;
            this.lbl2.Text = "Xk";
            // 
            // lbl3
            // 
            this.lbl3.AutoSize = true;
            this.lbl3.Location = new System.Drawing.Point(13, 104);
            this.lbl3.Name = "lbl3";
            this.lbl3.Size = new System.Drawing.Size(24, 17);
            this.lbl3.TabIndex = 7;
            this.lbl3.Text = "Dx";
            // 
            // lbl4
            // 
            this.lbl4.AutoSize = true;
            this.lbl4.Location = new System.Drawing.Point(13, 143);
            this.lbl4.Name = "lbl4";
            this.lbl4.Size = new System.Drawing.Size(17, 17);
            this.lbl4.TabIndex = 8;
            this.lbl4.Text = "A";
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(218, 62);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(102, 42);
            this.btn1.TabIndex = 9;
            this.btn1.Text = "Обрахувати";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(330, 450);
            this.Controls.Add(this.btn1);
            this.Controls.Add(this.lbl4);
            this.Controls.Add(this.lbl3);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.txtbox5);
            this.Controls.Add(this.txtbox4);
            this.Controls.Add(this.txtbox3);
            this.Controls.Add(this.txtbox2);
            this.Controls.Add(this.txtbox1);
            this.Name = "Form1";
            this.Text = "Табулювання функції";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txtbox1;
        private System.Windows.Forms.TextBox txtbox2;
        private System.Windows.Forms.TextBox txtbox3;
        private System.Windows.Forms.TextBox txtbox4;
        private System.Windows.Forms.TextBox txtbox5;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.Label lbl3;
        private System.Windows.Forms.Label lbl4;
        private System.Windows.Forms.Button btn1;
    }
}

