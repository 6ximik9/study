namespace lb7
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
            this.btn1 = new System.Windows.Forms.Button();
            this.btn2 = new System.Windows.Forms.Button();
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.lstBox1 = new System.Windows.Forms.ListBox();
            this.lstBox2 = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(25, 398);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(106, 34);
            this.btn1.TabIndex = 0;
            this.btn1.Text = "Заповнити";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // btn2
            // 
            this.btn2.Location = new System.Drawing.Point(231, 398);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(113, 34);
            this.btn2.TabIndex = 1;
            this.btn2.Text = "Замінити";
            this.btn2.UseVisualStyleBackColor = true;
            this.btn2.Click += new System.EventHandler(this.btn2_Click);
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(22, 21);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(130, 17);
            this.lbl1.TabIndex = 2;
            this.lbl1.Text = "Початковий масив";
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(218, 21);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(126, 17);
            this.lbl2.TabIndex = 3;
            this.lbl2.Text = "Отриманий масив";
            // 
            // lstBox1
            // 
            this.lstBox1.FormattingEnabled = true;
            this.lstBox1.ItemHeight = 16;
            this.lstBox1.Location = new System.Drawing.Point(12, 50);
            this.lstBox1.Name = "lstBox1";
            this.lstBox1.Size = new System.Drawing.Size(153, 324);
            this.lstBox1.TabIndex = 4;
            // 
            // lstBox2
            // 
            this.lstBox2.FormattingEnabled = true;
            this.lstBox2.ItemHeight = 16;
            this.lstBox2.Location = new System.Drawing.Point(207, 50);
            this.lstBox2.Name = "lstBox2";
            this.lstBox2.Size = new System.Drawing.Size(153, 324);
            this.lstBox2.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(403, 450);
            this.Controls.Add(this.lstBox2);
            this.Controls.Add(this.lstBox1);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.btn2);
            this.Controls.Add(this.btn1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.ListBox lstBox1;
        private System.Windows.Forms.ListBox lstBox2;
    }
}

