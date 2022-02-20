namespace lb3
{
    partial class lb3
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
            this.lbl1 = new System.Windows.Forms.Label();
            this.lbl2 = new System.Windows.Forms.Label();
            this.txtBox1 = new System.Windows.Forms.TextBox();
            this.txtBox2 = new System.Windows.Forms.TextBox();
            this.txtBox4 = new System.Windows.Forms.TextBox();
            this.btn2 = new System.Windows.Forms.Button();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.вихідToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.rdb1 = new System.Windows.Forms.RadioButton();
            this.rdb2 = new System.Windows.Forms.RadioButton();
            this.rdb3 = new System.Windows.Forms.RadioButton();
            this.btn1 = new System.Windows.Forms.Button();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(28, 50);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(29, 17);
            this.lbl1.TabIndex = 0;
            this.lbl1.Text = "X =";
            // 
            // lbl2
            // 
            this.lbl2.AutoSize = true;
            this.lbl2.Location = new System.Drawing.Point(29, 92);
            this.lbl2.Name = "lbl2";
            this.lbl2.Size = new System.Drawing.Size(28, 17);
            this.lbl2.TabIndex = 1;
            this.lbl2.Text = "q =";
            // 
            // txtBox1
            // 
            this.txtBox1.Location = new System.Drawing.Point(100, 47);
            this.txtBox1.Multiline = true;
            this.txtBox1.Name = "txtBox1";
            this.txtBox1.Size = new System.Drawing.Size(199, 26);
            this.txtBox1.TabIndex = 3;
            // 
            // txtBox2
            // 
            this.txtBox2.Location = new System.Drawing.Point(100, 89);
            this.txtBox2.Multiline = true;
            this.txtBox2.Name = "txtBox2";
            this.txtBox2.Size = new System.Drawing.Size(199, 26);
            this.txtBox2.TabIndex = 4;
            this.txtBox2.TextChanged += new System.EventHandler(this.txtBox2_TextChanged);
            // 
            // txtBox4
            // 
            this.txtBox4.Location = new System.Drawing.Point(36, 132);
            this.txtBox4.Multiline = true;
            this.txtBox4.Name = "txtBox4";
            this.txtBox4.Size = new System.Drawing.Size(338, 177);
            this.txtBox4.TabIndex = 6;
            // 
            // btn2
            // 
            this.btn2.Location = new System.Drawing.Point(250, 315);
            this.btn2.Name = "btn2";
            this.btn2.Size = new System.Drawing.Size(124, 45);
            this.btn2.TabIndex = 8;
            this.btn2.Text = "Очистити";
            this.btn2.UseVisualStyleBackColor = true;
            this.btn2.Click += new System.EventHandler(this.btn2_Click);
            // 
            // menuStrip1
            // 
            this.menuStrip1.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(20, 20);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.вихідToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(0, 0);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Size = new System.Drawing.Size(448, 28);
            this.menuStrip1.TabIndex = 9;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // вихідToolStripMenuItem
            // 
            this.вихідToolStripMenuItem.Name = "вихідToolStripMenuItem";
            this.вихідToolStripMenuItem.Size = new System.Drawing.Size(58, 24);
            this.вихідToolStripMenuItem.Text = "Вихід";
            this.вихідToolStripMenuItem.Click += new System.EventHandler(this.вихідToolStripMenuItem_Click);
            // 
            // rdb1
            // 
            this.rdb1.AutoSize = true;
            this.rdb1.Location = new System.Drawing.Point(333, 46);
            this.rdb1.Name = "rdb1";
            this.rdb1.Size = new System.Drawing.Size(50, 21);
            this.rdb1.TabIndex = 10;
            this.rdb1.TabStop = true;
            this.rdb1.Text = "x^2";
            this.rdb1.UseVisualStyleBackColor = true;
            this.rdb1.CheckedChanged += new System.EventHandler(this.rdb1_CheckedChanged);
            // 
            // rdb2
            // 
            this.rdb2.AutoSize = true;
            this.rdb2.Location = new System.Drawing.Point(333, 73);
            this.rdb2.Name = "rdb2";
            this.rdb2.Size = new System.Drawing.Size(50, 21);
            this.rdb2.TabIndex = 11;
            this.rdb2.TabStop = true;
            this.rdb2.Text = "e^x";
            this.rdb2.UseVisualStyleBackColor = true;
            this.rdb2.CheckedChanged += new System.EventHandler(this.rdb2_CheckedChanged);
            // 
            // rdb3
            // 
            this.rdb3.AutoSize = true;
            this.rdb3.Location = new System.Drawing.Point(333, 100);
            this.rdb3.Name = "rdb3";
            this.rdb3.Size = new System.Drawing.Size(60, 21);
            this.rdb3.TabIndex = 12;
            this.rdb3.TabStop = true;
            this.rdb3.Text = "sh(x)";
            this.rdb3.UseVisualStyleBackColor = true;
            this.rdb3.CheckedChanged += new System.EventHandler(this.rdb3_CheckedChanged);
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(36, 315);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(113, 44);
            this.btn1.TabIndex = 13;
            this.btn1.Text = "Пуск";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click_1);
            // 
            // lb3
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(448, 409);
            this.ControlBox = false;
            this.Controls.Add(this.btn1);
            this.Controls.Add(this.rdb3);
            this.Controls.Add(this.rdb2);
            this.Controls.Add(this.rdb1);
            this.Controls.Add(this.btn2);
            this.Controls.Add(this.txtBox4);
            this.Controls.Add(this.txtBox2);
            this.Controls.Add(this.txtBox1);
            this.Controls.Add(this.lbl2);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.menuStrip1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedDialog;
            this.MainMenuStrip = this.menuStrip1;
            this.Name = "lb3";
            this.Text = "lb3";
            this.Load += new System.EventHandler(this.lb3_Load);
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.Label lbl2;
        private System.Windows.Forms.TextBox txtBox1;
        private System.Windows.Forms.TextBox txtBox2;
        private System.Windows.Forms.TextBox txtBox4;
        private System.Windows.Forms.Button btn2;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem вихідToolStripMenuItem;
        private System.Windows.Forms.RadioButton rdb1;
        private System.Windows.Forms.RadioButton rdb2;
        private System.Windows.Forms.RadioButton rdb3;
        private System.Windows.Forms.Button btn1;
    }
}

