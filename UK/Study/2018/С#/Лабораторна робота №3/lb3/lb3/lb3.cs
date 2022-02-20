using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace lb3
{
    public partial class lb3 : Form
    {
        public lb3()
        {
            InitializeComponent();
        }

        private void label3_Click(object sender, EventArgs e)
        {

        }

        private void btn1_Click(object sender, EventArgs e)
        {
            //Отримання початкових даних
           

            
        }

        private void txtBox2_TextChanged(object sender, EventArgs e)
        {

        }

        private void btn2_Click(object sender, EventArgs e)
        {
            txtBox1.Clear();
            txtBox2.Clear();
            txtBox4.Clear();
        }

        private void lb3_Load(object sender, EventArgs e)
        {

        }

        private void вихідToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void rdb1_CheckedChanged(object sender, EventArgs e)
        {
            MessageBox.Show("Вибрана функція x^2");
            
        }

        private void rdb2_CheckedChanged(object sender, EventArgs e)
        {
            MessageBox.Show("Вибрана функція e^2");
        }
        
        private void btn1_Click_1(object sender, EventArgs e)
        {
            if(rdb1.Checked)
            {
                double x = Convert.ToDouble(txtBox1.Text);
                double q = Convert.ToDouble(txtBox2.Text);
                double u;
                u = Math.Log(Math.Abs(Math.Pow(Math.Exp(1), x)) + Math.Abs(q));
                txtBox4.Text += "Результат роботи програми" + Environment.NewLine;
                txtBox4.Text += "При Х = " + txtBox1.Text + Environment.NewLine;
                txtBox4.Text += "При q = " + txtBox2.Text + Environment.NewLine;
                txtBox4.Text += "U = " + u;
            }
            else if(rdb2.Checked)
            {
                double x = Convert.ToDouble(txtBox1.Text);
                double q = Convert.ToDouble(txtBox2.Text);
                double u;
                u = Math.Pow(Math.Exp(1), Math.Pow(x, 2)) + q;
                txtBox4.Text += "Результат роботи програми" + Environment.NewLine;
                txtBox4.Text += "При Х = " + txtBox1.Text + Environment.NewLine;
                txtBox4.Text += "При q = " + txtBox2.Text + Environment.NewLine;
                txtBox4.Text += "U = " + u;
            }
            else
            {
                double x = Convert.ToDouble(txtBox1.Text);
                double q = Convert.ToDouble(txtBox2.Text);
                double u;
                u = Math.Sinh(x)+q;
                txtBox4.Text += "Результат роботи програми" + Environment.NewLine;
                txtBox4.Text += "При Х = " + txtBox1.Text + Environment.NewLine;
                txtBox4.Text += "При q = " + txtBox2.Text + Environment.NewLine;
                txtBox4.Text += "U = " + u; 
            }
        }

        private void rdb3_CheckedChanged(object sender, EventArgs e)
        {
            MessageBox.Show("Вибрана функція sh(x)");
        }
    }
}
