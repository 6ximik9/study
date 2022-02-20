namespace lb6_2_
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
            this.lbl1 = new System.Windows.Forms.Label();
            this.lstbox = new System.Windows.Forms.ListBox();
            this.SuspendLayout();
            // 
            // btn1
            // 
            this.btn1.Location = new System.Drawing.Point(18, 234);
            this.btn1.Name = "btn1";
            this.btn1.Size = new System.Drawing.Size(78, 35);
            this.btn1.TabIndex = 0;
            this.btn1.Text = "Пуск";
            this.btn1.UseVisualStyleBackColor = true;
            this.btn1.Click += new System.EventHandler(this.btn1_Click);
            // 
            // lbl1
            // 
            this.lbl1.AutoSize = true;
            this.lbl1.Location = new System.Drawing.Point(131, 243);
            this.lbl1.Name = "lbl1";
            this.lbl1.Size = new System.Drawing.Size(0, 17);
            this.lbl1.TabIndex = 1;
            // 
            // lstbox
            // 
            this.lstbox.FormattingEnabled = true;
            this.lstbox.ItemHeight = 16;
            this.lstbox.Items.AddRange(new object[] {
            "z z z z ",
            "z zzzzz",
            "ав234ыы",
            "23ыфв45",
            "ыва4325"});
            this.lstbox.Location = new System.Drawing.Point(18, 14);
            this.lstbox.Name = "lstbox";
            this.lstbox.Size = new System.Drawing.Size(210, 212);
            this.lstbox.TabIndex = 2;
            this.lstbox.SelectedIndexChanged += new System.EventHandler(this.lstbox_SelectedIndexChanged);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(313, 310);
            this.Controls.Add(this.lstbox);
            this.Controls.Add(this.lbl1);
            this.Controls.Add(this.btn1);
            this.Name = "Form1";
            this.Text = "Form1";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn1;
        private System.Windows.Forms.Label lbl1;
        private System.Windows.Forms.ListBox lstbox;
    }
}

